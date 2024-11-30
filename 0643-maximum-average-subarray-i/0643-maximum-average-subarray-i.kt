class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var result = -100001.0
        for (i in 0 until nums.size - k + 1) {
            var sum = 0
            for (f in i until i + k) {
                sum += nums[f]
            }
            val avg = sum.toDouble() / k
            result = max(avg, result)
        }
        return result
    }
}