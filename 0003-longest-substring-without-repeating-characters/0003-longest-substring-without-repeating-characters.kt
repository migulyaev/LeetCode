class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var left = 0
        var right = 0
        var max = 0
        val set = hashSetOf<Char>()
        while (right < s.length) {
            if (set.contains(s[right])) {
                val leftChar = s[left]
                set.remove(leftChar)
                left++
            } else {
                set.add(s[right])
                val length = right - left + 1
                max = max(max, length)
                right++
            }
        }
        
        return max
    }
}