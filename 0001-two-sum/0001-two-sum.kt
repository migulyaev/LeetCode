class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numbers = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, num ->
            numbers[num] = index
        }
        
        nums.forEachIndexed { index, num ->
            val needToTarget = target - num
            if (numbers.containsKey(needToTarget) && numbers[needToTarget]!! != index) {
                return intArrayOf(index, numbers[needToTarget]!!)
            }
        }
        return intArrayOf()
    }
}