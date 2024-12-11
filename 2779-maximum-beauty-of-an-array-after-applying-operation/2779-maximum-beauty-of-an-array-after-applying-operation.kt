class Solution {
    fun maximumBeauty(nums: IntArray, k: Int): Int {
        nums.sort()
        var maxBeauty = 0

        for (i in nums.indices) {
            // Find the farthest index where the value is within the range [nums[i], nums[i] + 2*k]
            val upperBound = findUpperBound(nums, nums[i] + 2 * k)
            // Update the maximum beauty based on the current range
            maxBeauty = maxOf(maxBeauty, upperBound - i + 1)
        }
        return maxBeauty
    }

    // Helper function to find the largest index where arr[index] <= val
    private fun findUpperBound(arr: IntArray, p: Int): Int {
        var low = 0
        var high = arr.lastIndex
        var result = 0

        // Perform binary search to find the upper bound
        while (low <= high) {
            val mid = low + (high - low) / 2
            if (arr[mid] <= p) {
                result = mid // Update the result and move to the right half
                low = mid + 1
            } else {
                high = mid - 1 // Move to the left half
            }
        }
        return result
    }

}