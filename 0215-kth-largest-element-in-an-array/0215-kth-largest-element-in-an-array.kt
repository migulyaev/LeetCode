class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val queue = PriorityQueue<Int>() // Min-heap
        for (num in nums) {
            queue.offer(num)
            if (queue.size > k) {
                queue.poll() // Remove the smallest element to keep the size at k
            }
        }
        return queue.poll()
    }
}