class Solution {
    fun romanToInt(s: String): Int {
        var result = 0
        var last = 0
        for (i in s.length - 1 downTo(0)) {
            val number = convert(s[i])
            if (number >= last) {
                result += number
                last = number
            } else {
                result -= number
            }
        }
        return result
    }
    
    private fun convert(c: Char) = when (c) {
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        'M' -> 1000
        else -> 0
    }
}