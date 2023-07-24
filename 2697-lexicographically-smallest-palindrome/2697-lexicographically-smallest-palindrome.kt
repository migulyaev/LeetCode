class Solution {
    fun makeSmallestPalindrome(s: String): String {
        val median = s.length / 2
        val stringBuilder = StringBuilder(s)
        for (i in 0..median) {
            if (s[i] < s[s.length-i-1]) {
                stringBuilder[s.length-i-1] = s[i]
            } else if (s[i] > s[s.length-i-1]) {
                stringBuilder[i] = s[s.length-i-1]
            }
        }
        return stringBuilder.toString()
    }
}