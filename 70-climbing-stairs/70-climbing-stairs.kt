class Solution {
    
    private lateinit var cache: Array<Int>
    
    fun climbStairs(n: Int): Int {
        cache = Array<Int>(n) { 0 }
        return climbRecursive(n)
    }
    
    private fun climbRecursive(currentFloor: Int): Int {
        if (currentFloor <= 2) {
            return currentFloor
        }
        if (cache[currentFloor - 1] != 0) {
            return cache[currentFloor - 1]
        }
        return (climbRecursive(currentFloor - 1) + climbRecursive(currentFloor - 2)).apply {
            cache[currentFloor - 1] = this
        }
    }

}