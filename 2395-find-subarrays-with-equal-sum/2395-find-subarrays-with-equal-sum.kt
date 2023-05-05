class Solution {
    fun findSubarrays(nums: IntArray): Boolean {
        for (i in 0 until nums.size - 2) {
            for (k in i+1 until nums.size - 1) {
                if (nums[i] + nums[i+1] == nums[k] + nums[k+1]) {
                    return true
                }
            }
        }
        return false
    }
}