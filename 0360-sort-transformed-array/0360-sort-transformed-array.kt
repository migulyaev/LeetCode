class Solution {
    fun sortTransformedArray(nums: IntArray, a: Int, b: Int, c: Int): IntArray {
        val result = IntArray(nums.size)
        for (i in 0 until nums.size) {
            result[i] = nums[i] * nums[i] * a + nums[i] * b + c
        }
        result.sort()
        return result
    }
}