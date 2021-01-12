package kt.scaffold.common

import io.vertx.servicediscovery.Record;
import io.vertx.core.impl.ConcurrentHashSet
import io.vertx.core.json.JsonObject
import io.vertx.core.logging.Logger
import io.vertx.core.logging.LoggerFactory

import io.vertx.servicediscovery.ServiceDiscoveryOptions
import io.vertx.circuitbreaker.CircuitBreaker;
import io.vertx.circuitbreaker.CircuitBreakerOptions;
import io.vertx.core.*
import java.util.ArrayList
import java.util.function.Consumer
import io.vertx.core.AsyncResult
import io.vertx.servicediscovery.ServiceDiscovery
import io.vertx.servicediscovery.types.MessageSource;
import java.lang.Exception
import io.vertx.servicediscovery.types.EventBusService
import io.vertx.servicediscovery.types.HttpEndpoint
import kt.scaffold.Application


open class MicroServiceVerticle :AbstractVerticle(){

    private val logger: Logger = LoggerFactory.getLogger(MicroServiceVerticle::class.java)

    lateinit var  discovery: ServiceDiscovery ;
    lateinit var  circuitBreaker: CircuitBreaker
    val registeredRecords = ConcurrentHashSet<Record>()

    override fun start() {
        //init service discovery instance
        discovery = ServiceDiscovery.create(vertx,
            ServiceDiscoveryOptions().setBackendConfiguration(JsonObject())
        )

        //init circuit breaker instance
        val cbOptions = Application.circuitBreakerOptions()

        circuitBreaker = CircuitBreaker.create(cbOptions.getString("name", "circuit-breaker"),
            vertx,
            CircuitBreakerOptions()
                .setMaxFailures(cbOptions.getInteger("maxFailures", 5))
                .setTimeout(cbOptions.getLong("timeout", 10000L))
                .setFallbackOnFailure(cbOptions.getBoolean("fallbackOnFailure",true))
                .setResetTimeout(cbOptions.getLong("resetTimeout", 30000L)
            )
        )
    }

    fun publishHttpEndpoint(name: String, host: String, port: Int, completionHandler: Handler<AsyncResult<Void>>) {
        val record: Record = HttpEndpoint.createRecord(name, host, port, "/")
        publish(record, completionHandler)
    }

    fun publishMessageSource(
        name: String,
        address: String,
        contentClass: Class<*>,
        completionHandler: Handler<AsyncResult<Void>>
    ) {
        val record = MessageSource.createRecord(name, address, contentClass)
        publish(record, completionHandler)
    }

    fun publishMessageSource(name: String, address: String, completionHandler: Handler<AsyncResult<Void>>) {
        val record: Record = MessageSource.createRecord(name, address)
        publish(record, completionHandler)
    }

    fun publishEventBusService(
        name: String,
        address: String,
        serviceClass: Class<*>,
        metaJson:JsonObject,
        completionHandler: Handler<AsyncResult<Void>>
    ) {
        val record = EventBusService.createRecord(name, address, serviceClass, metaJson)
        publish(record, completionHandler)
    }

    private fun publish(record: Record, completionHandler: Handler<AsyncResult<Void>>) {
        if (discovery == null) {
            try {
                start()
            } catch (e: Exception) {
                throw RuntimeException("Cannot create discovery service")
            }
        }
        discovery.publish(record) { ar: AsyncResult<Record> ->
            if (ar.succeeded()) {
                registeredRecords.add(record)
            }
            completionHandler.handle(ar.map(null as Void?))
        }
    }

    override fun stop(stopPromise:Promise<Void>) {
        // In current design, the publisher is responsible for removing the service
        val futures: MutableList<Promise<Void>> = ArrayList()
        registeredRecords.forEach(Consumer { record: Record ->
            val cleanupFuture = Promise.promise<Void>()
            futures.add(cleanupFuture)

            discovery.unpublish(record.registration){
                cleanupFuture.complete()
            }
        })

        if (futures.isEmpty()) {
            discovery.close()
            stopPromise.complete()
        } else {
            val composite = CompositeFuture.all(futures.map { it.future() })
            composite.onComplete(){
                discovery.close()
                stopPromise.complete()
            }
            composite.onFailure(){
                discovery.close()
                stopPromise.fail(it.cause)
            }
        }

    }
}