class Solution {
    fun reverseWords(s: String): String {
        var result = ""
        var skipWhitespaces = true
        s.forEach {
            if (it == ' ') {
                if (skipWhitespaces) return@forEach
                result += " "
                skipWhitespaces = true
            } else {
                skipWhitespaces = false
                result += it
            }
        }
        return result.split(" ").reversed().joinToString(" ").trim()
    }
}