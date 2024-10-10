class Solution {
    fun minAddToMakeValid(s: String): Int {
        var openedParentheses = 0
        var closedParentheses = 0
        var i = 0
        var result = 0
        while (i < s.length) {
            val next = s[i]
            when {
                next == '(' && closedParentheses <= 0 -> {
                    openedParentheses++
                }
                next == '(' && closedParentheses > 0 -> {
                    result += closedParentheses
                    closedParentheses = 0
                    openedParentheses = 1
                }
                next == ')' && openedParentheses > 0 -> {
                    openedParentheses--
                }
                next == ')' && openedParentheses <= 0 -> {
                    closedParentheses++
                }
            }
            i++
        }
        return result + openedParentheses + closedParentheses
    }
}