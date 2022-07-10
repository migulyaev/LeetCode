class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val heap = PriorityQueue<Int> { o1, o2 -> o1!! - o2!! }
        
        for (i in nums) {
            heap.add(i)
            if (heap.size > k) {
                heap.poll()
            }
        }
        return heap.poll()
    }
}