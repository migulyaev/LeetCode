class Solution {
    fun reverseWords(s: String): String {
        val words = ArrayDeque<String>()
        var i = 0
        val word = StringBuilder()
        while (i < s.length) {
            while (i < s.length && s[i] == ' ') i++
            if (i == s.length) {
                continue
            }
            
            word.clear()
            while (i < s.length && s[i] != ' ') {
                word.append(s[i])
                i++
            }
            words.addFirst(word.toString())
        }
        return words.joinToString(" ")
    }
}