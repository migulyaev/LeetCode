class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        for (i in 0 until s.length) {
            val map = hashMapOf<Char, Int>()
            for (j in i until s.length) {
                if (map.contains(s[j])) {
                    max = Math.max(max, map.size)
                    break
                } else {
                    map.put(s[j], j)
                    max = Math.max(max, map.size)
                }
            }
        }
        return max
    }
}