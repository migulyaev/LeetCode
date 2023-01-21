class Solution {
    fun twoSumLessThanK(nums: IntArray, k: Int): Int {
        var max = -1
        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] < k && nums[i] + nums[j] > max) {
                    max = nums[i] + nums[j]
                }
            }
        }
        return max
    }
}