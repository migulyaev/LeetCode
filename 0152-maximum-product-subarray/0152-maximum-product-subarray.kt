class Solution {
    fun maxProduct(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        for (i in 0 until nums.size) {
            var product = 1
            for (k in i until nums.size) {
                product = product * nums[k]
                max = max(product, max)
            }
        }
        return max
    }
}