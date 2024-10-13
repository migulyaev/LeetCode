class Solution {
    fun countBits(n: Int): IntArray {
        val result = IntArray(n + 1) { 0 }
        result[0] = 0
        for (i in 1..n) { // O(N)
            result[i] = result[i.and(i-1)] + 1
        }
        return result
    }
}