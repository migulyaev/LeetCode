class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in 0 until nums.size - 1) {
            for (k in i + 1 until nums.size) {
                if (nums[i] + nums[k] == target) {
                    return intArrayOf(i, k)
                }
            }
        }
        return intArrayOf()
    }
}