class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var left = 0
        var right = 0
        var max = 0
        val symbols = hashSetOf<Char>()
        
        while (right < s.length) {
            if (symbols.contains(s[right])) {
                while (s[left] != s[right]) {
                    symbols.remove(s[left])
                    left++
                }
                left++
            } else {
                symbols.add(s[right])
                if (symbols.size > max) {
                    max = symbols.size
                }
            }
            right++
        }
        
        return max
    }
}