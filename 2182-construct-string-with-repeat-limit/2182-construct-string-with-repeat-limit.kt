class Solution {
    fun repeatLimitedString(s: String, repeatLimit: Int): String {
        val letters = hashMapOf<Char, Int>()
        s.forEach {
            letters[it] = (letters[it] ?: 0) + 1
        }
        
        val heap = PriorityQueue<Pair<Char, Int>>(Comparator { first, second ->
            second.first.code - first.first.code
        })
        letters.keys.forEach {
            heap.offer(Pair(it, letters[it]!!))
        }
        
        val result = StringBuilder()
        while (heap.isNotEmpty()) {
            val next = heap.remove()!!
            val total = min(repeatLimit, next.second)
            for (i in 1..total) {
                result.append(next.first)
            }
            
            if (next.second - total > 0) {
                if (heap.isNotEmpty()) {
                    heap.remove()?.let {
                        result.append(it.first)
                        if (it.second > 1) {
                            heap.offer(Pair(it.first, it.second - 1))
                        }
                    }
                    heap.offer(Pair(next.first, next.second - total))
                }
            }
        }
        return result.toString()
    }
}