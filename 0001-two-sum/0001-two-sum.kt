class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        for (i in 0 until nums.size) {
            if (map.containsKey(target - nums[i])) {
                return intArrayOf(i, map[target - nums[i]]!!)
            }
            map[nums[i]] = i
        }
        return intArrayOf()
    }
}