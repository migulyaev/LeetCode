class Solution {
    fun findTheArrayConcVal(nums: IntArray): Long {
        var left = 0
        var right = nums.size - 1
        var result = 0L
        while (left <= right) {
            if (left == right) {
                result += nums[left]
                left++
                break
            }
            val concatenated = (nums[left].toString() + nums[right].toString()).toLong()
            result += concatenated
            left++
            right--
        }
        return result
    }
}