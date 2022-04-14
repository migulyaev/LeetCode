class Solution {
    private val cache = hashMapOf<Int, Int>()
    
    fun rob(nums: IntArray): Int {
        cache.clear()
        return maxRob(0, nums)
    }
    
    private fun maxRob(currentIndex: Int, nums: IntArray): Int {
        if (currentIndex >= nums.size) return 0
        if (cache[currentIndex] != null) {
            return cache[currentIndex]!!
        }
        val result = Math.max(maxRob(currentIndex + 1, nums), maxRob(currentIndex + 2, nums) + nums[currentIndex])
        cache[currentIndex] = result
        return result
    }

}