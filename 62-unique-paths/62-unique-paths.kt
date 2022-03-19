class Solution {
    
    fun uniquePaths(m: Int, n: Int): Int {
        val paths = Array<Array<Int>>(m) { Array<Int>(n) { 1 } }
        
        for (i in 1 until m) {
            for (j in 1 until n) {
                paths[i][j] = paths[i-1][j] + paths[i][j-1]
            }
        }
        return paths[m-1][n-1]
    }
    
}