class Solution {
    fun distinctAverages(nums: IntArray): Int {
        val averages = hashSetOf<Int>()
        val list = nums.sorted().toMutableList()
        while (list.size > 0) {
            val sum = list[0] + list.last()
            averages.add(sum)
            list.removeAt(0)
            list.removeAt(list.size-1)
        }
        return averages.size
    }
}