class Solution {
    fun climbStairs(n: Int): Int {
        val steps = Array(n + 1) { 0 }
        steps[0] = 1
        steps[1] = 1
        for (i in 2..n) {
            steps[i] = steps[i - 1] + steps[i - 2]
        }
        return steps[n]
    }
}