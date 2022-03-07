class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val triplets = hashSetOf<List<Int>>()
        val result = arrayListOf<List<Int>>()
        
        if (nums.size < 3) {
            return emptyList()
        }
        
        nums.sort()
        
        
        for (i in 0 until nums.size - 2) {
            var left = i + 1
            var right = nums.size - 1
            while (left < right) {
                val sum = nums[left] + nums[right] + nums[i]
                if (sum == 0) {
                    triplets.add(listOf(nums[i], nums[left], nums[right]))
                    left++
                } else if (sum > 0) {
                    right--
                } else {
                    left++
                }
            }
        }
        
        triplets.forEach {
            result.add(it)   
        }
        return result
    }
}