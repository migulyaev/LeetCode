class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        if (s.length == 1) {
            return 1
        }
        val chars = Array<Int>(26) { 0 }
        var left = 0
        var right = 0
        var maxCountInWindow = 0
        var max = 0
        while (right < s.length) {
            val next = s[right]
            chars[next - 'A'] = chars[next - 'A'] + 1
            maxCountInWindow = max(maxCountInWindow, chars[next - 'A'])
            val length = right - left + 1
            if (length - maxCountInWindow > k) {
                chars[s[left] - 'A'] = chars[s[left] - 'A'] - 1
                left++
            } else {
                max = max(max, length)
            }
            right++
        }
        return max
    }
}