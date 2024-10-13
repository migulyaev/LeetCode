class Solution {
    fun hammingWeight(n: Int): Int {
        var bits = 0
        var tempN = n
        while (tempN > 0) {
            val bit = tempN % 2
            if (bit == 1) {
                bits++
            }
            tempN /= 2
        }
        return bits
    }
}