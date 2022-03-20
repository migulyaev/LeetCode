class Solution {
    
    private lateinit var startsCache: Array<Boolean?>

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        startsCache = Array<Boolean?>(s.length) { null }
        return wordBreakRecur(s, wordDict.toSet(), 0)
    }
    
    private fun wordBreakRecur(s: String, wordDict: Set<String>, start: Int): Boolean {
        if (start == s.length) {
            return true
        }
        if (startsCache[start] != null) {
            return startsCache[start]!!
        }
        for (end in start + 1..s.length) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakRecur(s, wordDict, end)) {
                startsCache[start] = true
                return true
            }
        }
        startsCache[start] = false
        return false
    }
}