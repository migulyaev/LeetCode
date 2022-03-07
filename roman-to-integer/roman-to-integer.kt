class Solution {
    fun romanToInt(s: String): Int {
        val stack = ArrayDeque<Char>()
        var result = 0
        for (i in 0 until s.length) {
            val lastElement = if (stack.isNotEmpty()) {
                stack.peek()
            } else {
                null
            }
            if (lastElement == null) {
                stack.push(s[i])
            } else {
                if (s[i].moreThan(lastElement)) {
                    result += (s[i].makeInt() - lastElement.makeInt())
                    stack.pop()
                } else {
                    stack.push(s[i])
                }
            }
        }
        while(stack.isNotEmpty()) {
            result += stack.pop().makeInt()
        }
        return result
    }
    
    private fun Char.moreThan(second: Char): Boolean {
        return this.makeInt() > second.makeInt()
    }
    
    private fun Char.lessThan(second: Char): Boolean {
        return this.makeInt() < second.makeInt()
    }
    
    private fun Char.makeInt(): Int {
        return when(this) {
            'I' -> 1;
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> throw IllegalStateException("Unknown")
        }
    }
}