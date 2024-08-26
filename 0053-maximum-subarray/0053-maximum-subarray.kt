class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var max = -1000000000
        var left = 0
        var right = 0
        var currentSum = 0
        while (right < nums.size) {
            val sumBefore = currentSum
            if (sumBefore < 0) {
                left = right
                currentSum = nums[right]
            } else {
                currentSum += nums[right]    
            }
            max = max(max, currentSum)
            right++
        }
        return max
    }
}