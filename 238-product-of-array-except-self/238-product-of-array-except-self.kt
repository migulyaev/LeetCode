class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val left = Array<Int>(nums.size) { 0 }
        left[0] = 1
        for (i in 1 until nums.size) {
            left[i] = left[i-1] * nums[i-1]
        }
        
        val right = Array<Int>(nums.size) { 0 }
        right[nums.size - 1] = 1
        for (i in nums.size-2 downTo 0) {
            right[i] = nums[i+1] * right[i+1]
        }
        
        val result = Array<Int>(nums.size) { 0 }
        for (i in 0 until nums.size) {
            result[i] = left[i] * right[i]
        }
        return result.toIntArray()
    }
}