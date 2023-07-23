class Solution {
    fun judgeSquareSum(c: Int): Boolean {
        var left = 0
        var right = Math.sqrt(c.toDouble()).toLong()
        while (right >= left) {
            val sum = left * left + right * right
            if (sum == c.toLong()) {
                return true
            } else if (sum > c.toLong()) {
                right--
            } else {
                left++
            }
        }
        return false
    }
}