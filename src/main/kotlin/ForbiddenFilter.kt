import java.util.BitSet
import kotlin.math.abs
import kotlin.math.ln
import kotlin.math.pow

class ForbiddenFilter(itemsCount: Int, private val fpProb: Float) {
    private var size: Int
    private var hashCount: Int
    private var bloomFilter: BitSet

    init {
        size = getSize(itemsCount, fpProb)
        hashCount = getHashCount(size, itemsCount)
        bloomFilter = BitSet(size)
        println(bloomFilter.toString())
    }

    private fun getSize(itemsCount: Int, fpProb: Float): Int {
        val size = -(itemsCount * ln(fpProb)) / (ln(2f).pow(2))
        return size.toInt()
    }

    private fun getHashCount(size: Int, itemsCount: Int): Int {
        val hashCount = (size / itemsCount) * ln(2f)
        return hashCount.toInt()
    }

    fun getSize(): Int {
        return size
    }

    fun getFpProb(): Float {
        return fpProb
    }

    fun getHashCount(): Int {
        return hashCount
    }

    fun addItem(item: String) {
        val code = abs(item.hashCode()).mod(size)
        bloomFilter.set(code)
    }

    fun test(item: String): Boolean {
        val code = abs(item.hashCode()).mod(size)
        return bloomFilter.get(code)
    }
}