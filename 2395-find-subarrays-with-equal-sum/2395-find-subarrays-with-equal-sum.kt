class Solution {
    fun findSubarrays(nums: IntArray): Boolean {
        val results = hashSetOf<Int>()
        for (i in 0 until nums.size - 1) {
            val sum = nums[i] + nums[i+1]
            if (results.contains(sum)) {
                return true
            } else {
                results.add(sum)
            }
        }
        return false
    }
}