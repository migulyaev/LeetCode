class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        for (i in 0 until nums.size) {
            val needAddToGetTarget = target - nums[i]
            if (map.containsKey(needAddToGetTarget)) {
                return intArrayOf(i, map[needAddToGetTarget]!!)
            } else {
                map[nums[i]] = i
            }
        }
        return intArrayOf()
    }
}