class Solution {
    fun myAtoi(s: String): Int {
        val string = s.trim()
        if (string.length == 0) {
            return 0
        }
        
        var i = 0
        var sign = 1
        var resultString = ""
        while (i < string.length && (string[i].isDigit() || string[i].isSign() && i == 0)) {
            if (string[i].isSign() && i == 0) {
                if (string[i] == '-') {
                    sign = -1
                }
            } else if (string[i].isDigit()) {
                resultString += string[i]
            }
            i++
        }
        
        var result = 0
        for (i in 0 until resultString.length) {
            val digit = resultString[i] - '0'
            if ((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return if (sign == 1) Integer.MAX_VALUE else Integer.MIN_VALUE
            }
            result = result * 10 + digit
        }
        return sign * result

    }
    
    private fun Char.isDigit() = this >= '0' && this <= '9'
    
    private fun Char.isSign() = this == '-' || this == '+'
}