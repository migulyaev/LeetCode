class RecentCounter() {
    
    private val pings = LinkedList<Int>()

    fun ping(t: Int): Int {
        pings.addLast(t)
        while (pings.getFirst() < t - 3000) pings.removeFirst()
        return pings.size
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */