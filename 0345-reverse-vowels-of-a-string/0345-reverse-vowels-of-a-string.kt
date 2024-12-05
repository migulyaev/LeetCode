class Solution {
    fun reverseVowels(s: String): String {
        val vowels = arrayListOf<Int>()
        for (i in 0 until s.length) {
            if (s[i].isVowel()) {
                vowels.add(i)
            }
        }
        val result = StringBuilder(s)
        var a = 0
        var z = vowels.size - 1
        while (a < z) {
            result[vowels[a]] = s[vowels[z]]
            result[vowels[z]] = s[vowels[a]]
            a++
            z--
        }
        return result.toString()
    }
    
    private fun Char.isVowel() = this == 'a' || this == 'A' || this == 'e' || this == 'E' || this == 'i' || this == 'I' || this == 'o' || this == 'O' || this == 'U' || this == 'u'
}