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
        var result = StringBuilder()
        stack.forEach {
            result.append(it)
        }
        return result.toString()
    }
}