class Solution {
    
    fun climbStairs(n: Int): Int {
        var first = 0
        var second = 1
        var result = 0
        for (i in 1..n) {
            result = first + second
            first = second
            second = result
        }
        
        
        return result
    }
    
}