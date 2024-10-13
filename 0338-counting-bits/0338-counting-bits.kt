class Solution {
    fun countBits(n: Int): IntArray {
        val result = IntArray(n + 1) { 0 }
        var offset = 1
        result[0] = 0
        for (i in 1..n) { // O(N)
            if (offset * 2 == i) {
                offset = i
            }
            result[i] = result[i - offset] + 1
        }
        return result
    }
}