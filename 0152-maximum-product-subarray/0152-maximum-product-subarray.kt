class Solution {
    fun maxProduct(nums: IntArray): Int {
        var max = nums[0]
        for (i in 0 until nums.size) {
            var product = 1
            for (k in i until nums.size) {
                product = product * nums[k]
                max = max(max, product)
            }
        }
        return max
    }
}