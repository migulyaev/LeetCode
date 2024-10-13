class Solution {
    fun countBits(n: Int): IntArray {
        val result = IntArray(n + 1) { 0 }
        for (i in 0..n) {
            var bits = 0
            var temp = i
            while (temp > 0) {
                val bit = temp % 2
                if (bit > 0) {
                    bits++
                }
                temp /= 2
            }
            result[i] = bits
        }
        return result
    }
}