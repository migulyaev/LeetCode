class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val left = Array<Int>(nums.size) { 0 }
        var leftProduct = 1

        for (i in 0 until nums.size) {
            left[i] = leftProduct
            leftProduct = leftProduct * nums[i]
        }
        
        val right = Array<Int>(nums.size) { 0 }
        var rightProduct = 1
        for (i in nums.size-1 downTo 0) {
            right[i] = rightProduct
            rightProduct = rightProduct * nums[i]
        }
        
        val result = Array<Int>(nums.size) { 0 }
        for (i in 0 until nums.size) {
            result[i] = left[i] * right[i]
        }
        return result.toIntArray()
    }
}