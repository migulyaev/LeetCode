class Solution {
    fun removeStars(s: String): String {
        val stack = ArrayDeque<Char>()
        for (c in s) {
            if (c == '*') {
                if (stack.isNotEmpty()) {
                    stack.removeLast()    
                }
            } else {
                stack.addLast(c)
            }
        }
        var result = ""
        stack.forEach {
            result += it
        }
        return result
    }
}