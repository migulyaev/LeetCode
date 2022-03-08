class Solution {
    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1
        while (i < j) {
            var left = s[i].toLowerCase()
            var right = s[j].toLowerCase()
            if (!left.isDigitOrLetter()) {
                i++
            }
            if (!right.isDigitOrLetter()) {
                j--
            }
            if (left.isDigitOrLetter() && right.isDigitOrLetter()) {
                if (right != left) {
                    return false
                }
                i++
                j--
            }
        }
        return true
    }
    
    private fun Char.isDigitOrLetter(): Boolean {
        return this >= 'a' && this <= 'z' || this >= 'A' && this <= 'Z' || this >= '0' && this <= '9'
    }
}