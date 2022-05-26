class Solution {
    fun lengthOfLastWord(s: String): Int {
        var result = 0
        for (i in s.length - 1 downTo 0) {
            if (result > 0 && s[i] == ' ') {
                break
            }
            if (s[i] != ' ') {
                result++
            }
        }
        return result
    }
}