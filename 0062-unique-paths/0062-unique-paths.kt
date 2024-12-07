class Solution {

    fun uniquePaths(m: Int, n: Int): Int {
        val array = Array<IntArray>(m) {
            IntArray(n) { 0 }
        }
        if (m == 0 && n == 0) {
            return 1
        }
        array[0][0] = 1
        for (i in 0 until m) {
            for (k in 0 until n) {
                if (i == 0 && k == 0) continue
                val prevI = if (i > 0) array[i - 1][k] else 0
                val prevK = if (k > 0) array[i][k - 1] else 0
                array[i][k] = prevI + prevK
            }
        }
        return array[m - 1][n - 1]
    }
}