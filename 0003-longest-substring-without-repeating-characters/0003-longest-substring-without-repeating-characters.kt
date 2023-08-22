class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        var left = 0
        val map = hashMapOf<Char, Int>()
        for (right in 0 until s.length) {
            if (map.containsKey(s[right])) {
                left = Math.max(map[s[right]]!! + 1, left)
            }
            max = Math.max(max, right - left + 1)
            map[s[right]] = right
        }
        return max
    }
}