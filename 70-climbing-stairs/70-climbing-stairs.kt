class Solution {
    
    fun climbStairs(n: Int): Int {
        if (n <= 2) return n
        val floors = Array<Int>(n + 1) { 0 }
        floors[1] = 1
        floors[2] = 2
        for (i in 3..n) {
            floors[i] = floors[i-1] + floors[i-2]
        }
        return floors[n]
    }


}