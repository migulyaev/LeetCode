class Solution {
    
    private val cache = hashMapOf<Int, Int>()
    
    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2
        return calculateClimb(n)
    }
    
    private fun calculateClimb(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2
        if (cache.containsKey(n)) {
            return cache[n]!!
        }
        return (calculateClimb(n - 1) + calculateClimb(n - 2)).also {
            cache[n] = it
        }
    }
}