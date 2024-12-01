class Solution {
    fun singleNumber(nums: IntArray): Int {
        val map = hashMapOf<Int, Int>()
        nums.forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        nums.forEach {
            if (map.get(it) == 1) {
                return it
            }
        }
        return 0
    }
}