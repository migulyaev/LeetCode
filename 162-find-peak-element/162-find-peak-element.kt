class Solution {
    fun findPeakElement(nums: IntArray): Int {
        if (nums.size == 1) {
            return 0
        }

        for (i in 0 until nums.size) {
            if (i == 0 && nums[i+1] < nums[i]) {
                return i
            }
            if (i == nums.size - 1 && nums[i-1] < nums[i]) {
                return i
            }
            if (i != 0 && i != nums.size - 1) {
                if (nums[i-1] < nums[i] && nums[i+1] < nums[i]) {
                    return i
                }
            }
        }
        return -1
    }
}