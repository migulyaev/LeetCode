class Solution {
    fun reverseVowels(s: String): String {
        val result = StringBuilder(s)
        var a = 0
        var z = s.length - 1
        while (a < z) {
            while (a < s.length && !s[a].isVowel()) a++
            while (z > 0 && !s[z].isVowel()) z--
            if (a >= z) continue
            result[a] = s[z]
            result[z] = s[a]
            a++
            z--
        }
        return result.toString()
    }
    
    private fun Char.isVowel() = this == 'a' || this == 'A' || this == 'e' || this == 'E' || this == 'i' || this == 'I' || this == 'o' || this == 'O' || this == 'U' || this == 'u'
}