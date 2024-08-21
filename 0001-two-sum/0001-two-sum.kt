class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val indices = hashMapOf<Int, Int>()
        for (i in 0 until nums.size) {
            val needToFind = target - nums[i]
            if (indices.containsKey(needToFind)) {
                return intArrayOf(i, indices[needToFind]!!)
            }
            indices[nums[i]] = i
        }
        return intArrayOf()
    }
}