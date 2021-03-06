// automatically generated by the FlatBuffers compiler, do not modify

package fb

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
@ExperimentalUnsignedTypes
class skillconfigTR : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : skillconfigTR {
        __init(_i, _bb)
        return this
    }
    val Id : Int
        get() {
            val o = __offset(4)
            return if(o != 0) bb.getInt(o + bb_pos) else 0
        }
    val Name : String?
        get() {
            val o = __offset(6)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val NameAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(6, 1)
    fun NameInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 6, 1)
    val Description : String?
        get() {
            val o = __offset(8)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val DescriptionAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(8, 1)
    fun DescriptionInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 8, 1)
    val Cooltime : Int
        get() {
            val o = __offset(10)
            return if(o != 0) bb.getInt(o + bb_pos) else 0
        }
    val Costsp : Int
        get() {
            val o = __offset(12)
            return if(o != 0) bb.getInt(o + bb_pos) else 0
        }
    val Attackdistance : Float
        get() {
            val o = __offset(14)
            return if(o != 0) bb.getFloat(o + bb_pos) else 0.0f
        }
    val Attackangle : Float
        get() {
            val o = __offset(16)
            return if(o != 0) bb.getFloat(o + bb_pos) else 0.0f
        }
    fun Attacktargettags(j: Int) : String? {
        val o = __offset(18)
        return if (o != 0) {
            __string(__vector(o) + j * 4)
        } else {
            null
        }
    }
    val AttacktargettagsLength : Int
        get() {
            val o = __offset(18); return if (o != 0) __vector_len(o) else 0
        }
    fun Impacttype(j: Int) : String? {
        val o = __offset(20)
        return if (o != 0) {
            __string(__vector(o) + j * 4)
        } else {
            null
        }
    }
    val ImpacttypeLength : Int
        get() {
            val o = __offset(20); return if (o != 0) __vector_len(o) else 0
        }
    val Nextbattlerid : Int
        get() {
            val o = __offset(22)
            return if(o != 0) bb.getInt(o + bb_pos) else 0
        }
    val Atkratio : Float
        get() {
            val o = __offset(24)
            return if(o != 0) bb.getFloat(o + bb_pos) else 0.0f
        }
    val Durationtime : Float
        get() {
            val o = __offset(26)
            return if(o != 0) bb.getFloat(o + bb_pos) else 0.0f
        }
    val Atkinterval : Float
        get() {
            val o = __offset(28)
            return if(o != 0) bb.getFloat(o + bb_pos) else 0.0f
        }
    val Skillprefab : String?
        get() {
            val o = __offset(30)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val SkillprefabAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(30, 1)
    fun SkillprefabInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 30, 1)
    val Animationname : String?
        get() {
            val o = __offset(32)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val AnimationnameAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(32, 1)
    fun AnimationnameInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 32, 1)
    val Hitfxprefab : String?
        get() {
            val o = __offset(34)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val HitfxprefabAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(34, 1)
    fun HitfxprefabInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 34, 1)
    val Level : Int
        get() {
            val o = __offset(36)
            return if(o != 0) bb.getInt(o + bb_pos) else 0
        }
    val Attacktype : Int
        get() {
            val o = __offset(38)
            return if(o != 0) bb.getInt(o + bb_pos) else 0
        }
    val Selectortype : Int
        get() {
            val o = __offset(40)
            return if(o != 0) bb.getInt(o + bb_pos) else 0
        }
    override fun keysCompare(o1: Int, o2: Int, _bb: ByteBuffer) : Int {
        val val_1 = _bb.getInt(__offset(4, o1, _bb))
        val val_2 = _bb.getInt(__offset(4, o2, _bb))
        return (val_1 - val_2).sign
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_1_12_0()
        fun getRootAsskillconfigTR(_bb: ByteBuffer): skillconfigTR = getRootAsskillconfigTR(_bb, skillconfigTR())
        fun getRootAsskillconfigTR(_bb: ByteBuffer, obj: skillconfigTR): skillconfigTR {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createskillconfigTR(builder: FlatBufferBuilder, Id: Int, NameOffset: Int, DescriptionOffset: Int, Cooltime: Int, Costsp: Int, Attackdistance: Float, Attackangle: Float, AttacktargettagsOffset: Int, ImpacttypeOffset: Int, Nextbattlerid: Int, Atkratio: Float, Durationtime: Float, Atkinterval: Float, SkillprefabOffset: Int, AnimationnameOffset: Int, HitfxprefabOffset: Int, Level: Int, Attacktype: Int, Selectortype: Int) : Int {
            builder.startTable(19)
            addSelectortype(builder, Selectortype)
            addAttacktype(builder, Attacktype)
            addLevel(builder, Level)
            addHitfxprefab(builder, HitfxprefabOffset)
            addAnimationname(builder, AnimationnameOffset)
            addSkillprefab(builder, SkillprefabOffset)
            addAtkinterval(builder, Atkinterval)
            addDurationtime(builder, Durationtime)
            addAtkratio(builder, Atkratio)
            addNextbattlerid(builder, Nextbattlerid)
            addImpacttype(builder, ImpacttypeOffset)
            addAttacktargettags(builder, AttacktargettagsOffset)
            addAttackangle(builder, Attackangle)
            addAttackdistance(builder, Attackdistance)
            addCostsp(builder, Costsp)
            addCooltime(builder, Cooltime)
            addDescription(builder, DescriptionOffset)
            addName(builder, NameOffset)
            addId(builder, Id)
            return endskillconfigTR(builder)
        }
        fun startskillconfigTR(builder: FlatBufferBuilder) = builder.startTable(19)
        fun addId(builder: FlatBufferBuilder, Id: Int) = builder.addInt(0, Id, 0)
        fun addName(builder: FlatBufferBuilder, Name: Int) = builder.addOffset(1, Name, 0)
        fun addDescription(builder: FlatBufferBuilder, Description: Int) = builder.addOffset(2, Description, 0)
        fun addCooltime(builder: FlatBufferBuilder, Cooltime: Int) = builder.addInt(3, Cooltime, 0)
        fun addCostsp(builder: FlatBufferBuilder, Costsp: Int) = builder.addInt(4, Costsp, 0)
        fun addAttackdistance(builder: FlatBufferBuilder, Attackdistance: Float) = builder.addFloat(5, Attackdistance, 0.0)
        fun addAttackangle(builder: FlatBufferBuilder, Attackangle: Float) = builder.addFloat(6, Attackangle, 0.0)
        fun addAttacktargettags(builder: FlatBufferBuilder, Attacktargettags: Int) = builder.addOffset(7, Attacktargettags, 0)
        fun createAttacktargettagsVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startAttacktargettagsVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun addImpacttype(builder: FlatBufferBuilder, Impacttype: Int) = builder.addOffset(8, Impacttype, 0)
        fun createImpacttypeVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addOffset(data[i])
            }
            return builder.endVector()
        }
        fun startImpacttypeVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun addNextbattlerid(builder: FlatBufferBuilder, Nextbattlerid: Int) = builder.addInt(9, Nextbattlerid, 0)
        fun addAtkratio(builder: FlatBufferBuilder, Atkratio: Float) = builder.addFloat(10, Atkratio, 0.0)
        fun addDurationtime(builder: FlatBufferBuilder, Durationtime: Float) = builder.addFloat(11, Durationtime, 0.0)
        fun addAtkinterval(builder: FlatBufferBuilder, Atkinterval: Float) = builder.addFloat(12, Atkinterval, 0.0)
        fun addSkillprefab(builder: FlatBufferBuilder, Skillprefab: Int) = builder.addOffset(13, Skillprefab, 0)
        fun addAnimationname(builder: FlatBufferBuilder, Animationname: Int) = builder.addOffset(14, Animationname, 0)
        fun addHitfxprefab(builder: FlatBufferBuilder, Hitfxprefab: Int) = builder.addOffset(15, Hitfxprefab, 0)
        fun addLevel(builder: FlatBufferBuilder, Level: Int) = builder.addInt(16, Level, 0)
        fun addAttacktype(builder: FlatBufferBuilder, Attacktype: Int) = builder.addInt(17, Attacktype, 0)
        fun addSelectortype(builder: FlatBufferBuilder, Selectortype: Int) = builder.addInt(18, Selectortype, 0)
        fun endskillconfigTR(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
        fun __lookup_by_key(obj: skillconfigTR?, vectorLocation: Int, key: Int, bb: ByteBuffer) : skillconfigTR? {
            var span = bb.getInt(vectorLocation - 4)
            var start = 0
            while (span != 0) {
                var middle = span / 2
                val tableOffset = __indirect(vectorLocation + 4 * (start + middle), bb)
                val value = bb.getInt(__offset(4, bb.capacity() - tableOffset, bb))
                val comp = value.compareTo(key)
                when {
                    comp > 0 -> span = middle
                    comp < 0 -> {
                        middle++
                        start += middle
                        span -= middle
                    }
                    else -> {
                        return (obj ?: skillconfigTR()).__assign(tableOffset, bb)
                    }
                }
            }
            return null
        }
    }
}
