class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var si = 0 
        var st = 0
        while (si < s.length && st < t.length) {
            if (s[si] == t[st]) {
                si++
            }
            st++
        }
        return si == s.length;
    }
}  