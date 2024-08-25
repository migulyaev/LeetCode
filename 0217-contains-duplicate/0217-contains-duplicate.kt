class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val memo = hashSetOf<Int>()
        for (i in nums) {
            if (memo.contains(i)) {
                return true
            }
            memo.add(i)
        }
        return false
    }
}