class Solution {
fun productExceptSelf(nums: IntArray): IntArray {
        val cacheLeft = IntArray(nums.size) { 1 }
        val cacheRight = IntArray(nums.size) { 1 }
        var product = 1
        for (i in 0 until nums.size - 1) {
            product = product * nums[i]
            cacheLeft[i] = product
        }
        product = 1
        for (i in nums.size - 1 downTo 0) {
            product = product * nums[i]
            cacheRight[i] = product
        }
        
        val result = IntArray(nums.size) { 1 }
        for (i in 0 until nums.size) {
            if (i == 0) {
                result[0] = cacheRight[1]
            } else if (i == nums.size - 1) {
                result[nums.size-1] = cacheLeft[nums.size-2]
            } else {
                result[i] = cacheLeft[i-1]*cacheRight[i+1]
            }
        }
        return result
    }
}