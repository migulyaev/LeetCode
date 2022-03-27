class Solution {
    fun backspaceCompare(s: String, t: String): Boolean {
        val first = ArrayDeque<Char>()
        val second = ArrayDeque<Char>()
        s.forEach {
            if (it != '#') {
                first.push(it)
            } else if (first.size > 0) {
                first.pop()
            }
        }
        
        t.forEach {
            if (it != '#') {
                second.push(it)
            } else if (second.size > 0) {
                second.pop()
            }
        }
        
        if (first.size != second.size) {
            return false
        }
        
        while (first.size > 0) {
            if (first.pop() != second.pop()) {
                return false
            }
        }
        
        return true
    }
}