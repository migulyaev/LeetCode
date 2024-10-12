class Solution {
    fun maxWidthRamp(nums: IntArray): Int {
                val maxes = IntArray(nums.size) { 0 }
        var maxValue = 0
        for (i in (nums.size - 1).downTo(0)) {
            maxValue = max(maxValue, nums[i])
            maxes[i] = maxValue
        }

        var left = 0
        var right = 0
        var max = 0
        while (right < nums.size) {
            if (nums[left] > maxes[right]) {
                left++
            }
            max = max(max, right - left)
            right++
        }
        return max
    }
}