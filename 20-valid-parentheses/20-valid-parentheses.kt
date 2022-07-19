class Solution {
    fun isValid(s: String): Boolean {
        val openedBraces = Stack<Char>()
        for (i in 0 until s.length) {
            when (s[i]) {
                '(' -> {
                    openedBraces.add(s[i])
                }
                ')' -> {
                    if (openedBraces.size == 0) {
                        return false
                    }
                    val lastOpened = openedBraces.pop()
                    if (lastOpened != '(') return false
                }
                '[' -> {
                    openedBraces.add(s[i])
                }
                ']' -> {
                    if (openedBraces.size == 0) {
                        return false
                    }
                    val lastOpened = openedBraces.pop()
                    if (lastOpened != '[') return false
                }
                '{' -> {
                    openedBraces.add(s[i])
                }
                '}' -> {
                    if (openedBraces.size == 0) {
                        return false
                    }
                    val lastOpened = openedBraces.pop()
                    if (lastOpened != '{') return false
                }
            }
        }
        return openedBraces.size == 0
    }
}