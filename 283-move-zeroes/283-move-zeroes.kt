class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        val indexes = IntArray(nums.size) { -1 }
        var indexOfNonZero = 0
        var countOfZeros = 0
        for (i in 0 until nums.size) {
            if (nums[i] != 0) {
                indexes[i] = indexOfNonZero
                indexOfNonZero++
            } else {
                countOfZeros++
            }
        }
        for (i in 0 until indexes.size) {
            if (indexes[i] != -1) {
                nums[indexes[i]] = nums[i]
            }
        }
        for (i in nums.size - countOfZeros until nums.size) {
            nums[i] = 0
        }
    }

}