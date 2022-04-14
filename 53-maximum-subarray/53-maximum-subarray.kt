class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var currentSum = 0
        var maxSum = -10001
        for (i in 0 until nums.size) {
            currentSum += nums[i]
            if (currentSum > maxSum) {
                maxSum = currentSum
            } 
            if (currentSum < 0) {
                currentSum = 0
            }
        }
        return maxSum
    }
}