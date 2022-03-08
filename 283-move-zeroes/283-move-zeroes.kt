class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var indexOfNonZero = 0
        for (i in 0 until nums.size) {
            if (nums[i] != 0) {
                nums[indexOfNonZero] = nums[i]
                indexOfNonZero++
            }
        }
        for (i in indexOfNonZero until nums.size) {
            nums[i] = 0
        }
    }

}