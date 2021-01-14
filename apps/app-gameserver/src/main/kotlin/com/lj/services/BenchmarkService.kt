package com.lj.services

import com.lj.core.net.msg.Msg
import io.vertx.codegen.annotations.ProxyGen
import io.vertx.codegen.annotations.VertxGen
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

@VertxGen
@ProxyGen
interface BenchmarkService{

    fun test(
        msg: Msg,
        handler: Handler<AsyncResult<Msg>>
    )


}