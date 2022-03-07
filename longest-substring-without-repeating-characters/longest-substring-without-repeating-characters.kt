class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var maxLength = 0
        if (s.length == 1) { 
            return 1
        }
        for (i in 0 until s.length - 1) {
            var currentLength = 1
            val existedSymbols = hashSetOf<Char>(s[i])
            for (j in i + 1 until s.length) {
                if (existedSymbols.contains(s[j])) {
                    break
                } else {
                    existedSymbols.add(s[j])
                    currentLength++
                }
            }
            if (currentLength > maxLength) {
                maxLength = currentLength
            }
        }
        return maxLength
    }
}