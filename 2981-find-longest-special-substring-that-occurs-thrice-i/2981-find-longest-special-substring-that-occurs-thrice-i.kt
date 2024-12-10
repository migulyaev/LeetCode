class Solution {
    fun maximumLength(s: String): Int {
        val sequencesQueue = ArrayDeque<Pair<Char, Int>>()
        var lastSymbol: Char = s[0]
        for (i in 0 until s.length) {
            if (i == 0) {
                lastSymbol = s[i]
                sequencesQueue.addFirst(Pair(s[i], 1))
            } else {
                if (lastSymbol != s[i]) {
                    lastSymbol = s[i]
                    sequencesQueue.addFirst(Pair(s[i], 1))
                } else {
                    val lastPair = sequencesQueue.removeFirst()
                    sequencesQueue.addFirst(Pair(s[i], lastPair.second + 1))
                }
            }
        }
        
        val goodSubstrings = HashMap<Char, ArrayList<Int>>()
        while (sequencesQueue.isNotEmpty()) {
            val subsequence = sequencesQueue.removeFirst()
                            goodSubstrings[subsequence.first] = (goodSubstrings[subsequence.first] ?: ArrayList<Int>()).apply {
                    add(subsequence.second)
                }
        }
        
        var max = -1
        for (key in goodSubstrings.keys) {
            val substrings = goodSubstrings[key]!!
            substrings.sort()
            if (substrings.size == 1) {
                if (substrings.first() < 3) continue
                if (substrings.first() == 3) {
                    max = max(max, 1)
                    continue
                }
                max = max(max, substrings.first() - 2)
            } else if (substrings.size == 2) {
                if (substrings.first() == 1 && substrings.last() == 1) continue
                if (substrings.first() == substrings.last()) {
                    max = max(max, substrings.last() - 1)
                    continue
                }
                val potentialString = if (substrings.last() - 1 <= substrings.first()) {
                    substrings.last() - 1
                } else {
                    -1
                }
                max = max(max, max(substrings.last() - 2, potentialString))
            } else {
                max = max(max, substrings[substrings.size - 3])
                val potentialString = if (substrings.last() - 1 <= substrings[substrings.size - 2]) {
                    substrings.last() - 1
                } else {
                    -1
                }
                max = max(max, max(substrings.last() - 2, potentialString))
            }
        }
        return max
    }
}