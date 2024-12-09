class Solution {
    fun isArraySpecial(nums: IntArray, queries: Array<IntArray>): BooleanArray {
        val violatingIndices = arrayListOf<Int>()
        for (i in 1 until nums.size) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                violatingIndices.add(i)
            }
        }
        
        val result = BooleanArray(queries.size) { false }
        for (i in 0 until queries.size) {
            val start = queries[i][0]
            val end = queries[i][1]
            
            val hasViolatingIndex = hasViolatingIndex(start + 1, end, violatingIndices)
            result[i] = !hasViolatingIndex
        }
        return result
    }
    
    private fun hasViolatingIndex(start: Int, end: Int, indices: List<Int>): Boolean {
        var left = 0
        var right = indices.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            val violatingIndex = indices[mid]
            if (violatingIndex < start) {
                left = mid + 1
            } else if (violatingIndex > end) {
                right = mid - 1
            } else {
                return true
            }
        }
        return false
    }
}