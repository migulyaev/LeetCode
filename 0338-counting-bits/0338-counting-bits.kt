class Solution {
    fun countBits(n: Int): IntArray {
        val ans = IntArray(n + 1) { 0 }
        for (i in 0..n) {
            var count = 0
            var temp = i
            while (temp > 0) {
                if (temp % 2 == 1) count++
                temp /= 2
            }
            ans[i] = count
        }
        return ans
    }
}