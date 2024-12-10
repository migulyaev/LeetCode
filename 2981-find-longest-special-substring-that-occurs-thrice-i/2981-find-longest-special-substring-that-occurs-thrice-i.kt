class Solution {
    fun maximumLength(s: String): Int {
    val sequencesQueue = ArrayDeque<Pair<Char, Int>>()
    var count = 1

    // Build sequences of consecutive characters
    for (i in 1..s.length) {
        if (i == s.length || s[i] != s[i - 1]) {
            sequencesQueue.addFirst(Pair(s[i - 1], count))
            count = 1
        } else {
            count++
        }
    }

    // Group subsequences by character and their lengths
    val goodSubstrings = sequencesQueue.groupBy({ it.first }, { it.second })
        .mapValues { ArrayList(it.value) }
        
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