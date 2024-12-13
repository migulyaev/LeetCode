class Solution {
    fun findScore(nums: IntArray): Long {
        var score = 0L
        val marked = BooleanArray(nums.size) { false }
        val heap = PriorityQueue<Pair<Int, Int>>(Comparator { pair1, pair2 ->
            val result = pair1.first - pair2.first
            if (result != 0) {
                result
            } else {
                pair1.second - pair2.second
            }
        })
        for (i in 0 until nums.size) {
            heap.offer(Pair(nums[i], i))
        }
        while (heap.isNotEmpty()) {
            val element = heap.remove()!!
            if (marked[element.second]) continue
            score += element.first
            marked[element.second] = true
            if (element.second > 0) {
                marked[element.second - 1] = true
            }
            if (element.second < nums.size - 1) {
                marked[element.second + 1] = true
            }
        }
        return score
    }
}