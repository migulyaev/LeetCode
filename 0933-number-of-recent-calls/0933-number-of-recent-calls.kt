class RecentCounter() {
    
    private val pings = PriorityQueue<Int>()

    fun ping(t: Int): Int {
        while (pings.peek() != null && pings.peek() + 3000 < t) {
            pings.remove()
        }
        pings.offer(t)
        return pings.size
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */