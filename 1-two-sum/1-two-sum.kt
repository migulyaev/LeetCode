class Solution {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numbers = hashMapOf<Int, Int>()
        for (i in 0 until nums.size) {
            numbers[nums[i]] = i
        }
        for (i in 0 until nums.size) {
            val needed = target - nums[i]
            if (numbers.containsKey(needed) && numbers[needed] != i) {
                return intArrayOf(i, numbers[needed]!!)
            }
        }
        return intArrayOf()
    }
}