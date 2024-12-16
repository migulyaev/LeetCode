class Solution {
    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        val values = PriorityQueue<Pair<Int, Int>>(Comparator { a, b -> 
            val v = a.first - b.first 
            if (v == 0) {
                a.second - b.second
            } else {
                v
            }
        })
        for (i in 0 until nums.size) {
            values.offer(Pair(nums[i], i))
        }
        
        for (i in 0 until k) {
            val value = values.remove()!!
            values.offer(Pair(value.first * multiplier, value.second))
        }

        val result = IntArray(nums.size) { 0 }
        while (values.isNotEmpty()) {
            val v = values.remove()!!
            result[v.second] = v.first
        }
        return result
    }
}