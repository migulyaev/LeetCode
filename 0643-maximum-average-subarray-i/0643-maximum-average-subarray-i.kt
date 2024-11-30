class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var currentSum = 0.0
        for (i in 0 until k) {
            currentSum += nums[i]
        }
        var max = currentSum / k
        var endPointer = k
        
        while (endPointer < nums.size) {
            currentSum = currentSum + (-nums[endPointer - k] + nums[endPointer])
            max = max(currentSum / k, max)
            endPointer++
        }
        return max
    }
}