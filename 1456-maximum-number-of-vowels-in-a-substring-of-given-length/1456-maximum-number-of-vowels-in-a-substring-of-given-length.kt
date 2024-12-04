class Solution {
    fun maxVowels(s: String, k: Int): Int {
        var currentVowels = 0
        for (i in 0 until k) {
            if (s[i].isVowel()) {
                currentVowels++
            }
        }
        var max = currentVowels
        var left = 0
        var right = k - 1
        while (right < s.length - 1) {
            if (s[left].isVowel()) currentVowels--
            left++
            right++
            if (s[right].isVowel()) currentVowels++
            max = max(max, currentVowels)
        }
        return max
    }
    
    private fun Char.isVowel() = this == 'a' || this == 'e' || this == 'u' || this == 'o' || this == 'i'
}