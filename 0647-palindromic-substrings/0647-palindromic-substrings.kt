class Solution {
    fun countSubstrings(s: String): Int {
        var result = 0

        for (i in 0 until s.length) {
            for (k in (s.length - 1).downTo(i)) {
                var start = i
                var end = k
                while (start < end) {
                    if (s[start] == s[end]) {
                        start++
                        end--
                    } else {
                        break
                    }
                }
                if (start >= end) {
                    result++
                }
            }
        }

        return result
    }
}