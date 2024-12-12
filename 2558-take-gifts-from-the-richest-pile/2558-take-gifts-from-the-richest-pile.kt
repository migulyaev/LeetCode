class Solution {
    fun pickGifts(gifts: IntArray, k: Int): Long {
        val minHeap = PriorityQueue<Int>(Comparator { a, b -> b - a })
        for (i in 0 until gifts.size) {
            minHeap.offer(gifts[i])
        }
        for (i in 0 until k) {
            minHeap.remove()?.let { first ->
                minHeap.offer(Math.sqrt(first.toDouble()).toInt())
            }
        }
        var result = 0L
        while (minHeap.isNotEmpty()) {
            result += minHeap.remove()?.toLong() ?: 0L
        }
        return result
    }
    
    private fun maxIndex(arr: IntArray): Int {
        var maxIndex = 0
        for (i in 0 until arr.size) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i
            }
        }
        return maxIndex
    }
}