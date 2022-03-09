class Solution {
    private val memo = hashMapOf<Int, Int>()

    fun numDecodings(s: String): Int {
        memo.clear()
        return recursiveWithMemo(0, s)
    }
    
    private fun recursiveWithMemo(i: Int, s: String): Int {
        if (memo.containsKey(i)) {
            return memo[i]!!
        }
        
        if (i == s.length) {
            return 1
        }
        
        if (s[i] == '0') {
            return 0
        }
        
        if (i == s.length - 1) {
            return 1
        }
        
        var answer = recursiveWithMemo(i + 1, s)
        if (s.substring(i, i+2).toInt() <= 26) {
            answer += recursiveWithMemo(i + 2, s)
        }
        
        memo[i] = answer
        
        return answer
    }
}