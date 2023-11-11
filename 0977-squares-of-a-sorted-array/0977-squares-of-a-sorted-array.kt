class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 0 }

        var right = nums.size - 1
        var left = 0

        for (i in nums.size - 1 downTo(0)) {
            var square: Int = 0
            if (abs(nums[left]) < abs(nums[right])) {
                result[i] = nums[right] * nums[right]
                right--
            } else {
                result[i] = nums[left] * nums[left]
                left++
            }
        }
        
        return result
    }
}