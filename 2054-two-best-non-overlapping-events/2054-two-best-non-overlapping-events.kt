class Solution {
    fun maxTwoEvents(events: Array<IntArray>): Int {
        events.sortWith(object: Comparator<IntArray> {
            override fun compare(o1: IntArray?, o2: IntArray?): Int {
                return o1!![0] - o2!![0]
            }
        })
        
        val pq = PriorityQueue<IntArray>(
            Comparator.comparingInt { it[1] }
        )
        
        var maxVal = 0
        var maxSum = 0
        for (event in events) {
            while (pq.isNotEmpty() && pq.peek()!![1] < event[0]) {
                maxVal = max(maxVal, pq.peek()[2])
                pq.poll()
            }
            maxSum = max(maxSum, maxVal + event[2])
            pq.add(event)
        }
        return maxSum
    }
}