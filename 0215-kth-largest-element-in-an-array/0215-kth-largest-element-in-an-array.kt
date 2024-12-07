class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
       val queue = PriorityQueue<Int> { f, s ->
          if (s > f) 1 else -1
       }
       for (i in nums) {
           queue.offer(i)
       }
       var i = 0
       while (true) {
           val element = queue.poll()
           i++
           if (i == k) {
               return element
           }
       }
       return 0
    }
}