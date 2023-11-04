class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        for (i in 0 until s.length) {
            val symbols = hashSetOf<Char>()
            for (k in i until s.length) {
                if (symbols.contains(s[k])) {
                    break
                } else {
                    symbols.add(s[k])
                }
            }
            if (symbols.size > max) {
                max = symbols.size
            }
        }
        return max
    }
}