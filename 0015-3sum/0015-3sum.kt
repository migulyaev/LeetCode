class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        // nums.sort()
        val result = hashSetOf<List<Int>>()
        val positions = hashMapOf<Int, List<Int>>()
        
        // nums.forEachIndexed
        
        for (i in 0 until nums.size - 2) {
            val twoSum = twoSum(nums.copyOfRange(i + 1, nums.size), -nums[i])
            twoSum.forEach {
                if (it.size == 2) {
                    result.add(listOf(it[0], it[1], nums[i]).sorted())
                }
            }
        }
        return result.toList()
    }
    
    private fun twoSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        val numbers = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, num ->
            val needToTarget = target - num
            if (numbers.containsKey(needToTarget)) {
                result.add(listOf(num, needToTarget!!))
            }
            numbers[num] = index
        }
        return result
    }
}