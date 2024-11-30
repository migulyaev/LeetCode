class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var zeroes = 0
        for (i in nums) {
            if (i == 0) zeroes++
        }
        if (zeroes == 0) {
            return
        }
        var i = 0
        for (k in 0 until nums.size) {
            if (nums[k] != 0) {
                nums[i] = nums[k]
                i++
            }
        }
        for (k in nums.size - 1 downTo nums.size - zeroes) {
            nums[k] = 0
        }
    }
}