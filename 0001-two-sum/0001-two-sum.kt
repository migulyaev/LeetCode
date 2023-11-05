class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numbers = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, num ->
            val needToTarget = target - num
            if (numbers.containsKey(needToTarget)) {
                return intArrayOf(index, numbers[needToTarget]!!)
            }
            numbers[num] = index
        }
        
        return intArrayOf()
    }
}