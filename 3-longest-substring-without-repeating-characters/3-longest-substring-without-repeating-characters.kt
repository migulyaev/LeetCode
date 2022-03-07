class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length == 1) { 
            return 1
        }
        
        var maxLength = 0
        
        val symbols = hashMapOf<Char, Int>()
        var left = 0
        var right = 0
        
        while (right < s.length) {
            val rightSymbol = s[right]
            val previousIndexOfThisSymbol = symbols[rightSymbol]
            if (previousIndexOfThisSymbol != null && previousIndexOfThisSymbol >= left && previousIndexOfThisSymbol < right) {
                left = symbols[rightSymbol]!! + 1
            }
            maxLength = Math.max(maxLength, right - left + 1)
            symbols[rightSymbol] = right
            right++
        }
        return maxLength
    }
}