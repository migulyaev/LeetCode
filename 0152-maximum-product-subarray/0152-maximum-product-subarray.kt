class Solution {
    fun maxProduct(nums: IntArray): Int {
        var result = nums[0]
        var curMax = 1
        var curMin = 1
        for (i in 0 until nums.size) {
            if (nums[i] == 0) {
                curMax = 1
                curMin = 1
                result = max(0, result)
                continue
            }
            val tmpCurMax = curMax
            curMax = max(max(curMin * nums[i], curMax * nums[i]), nums[i])
            curMin = min(min(tmpCurMax * nums[i], curMin * nums[i]), nums[i])
            result = max(curMax, result)
        }
        return result
    }
}