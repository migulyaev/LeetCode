class Solution {
    fun lengthOfLastWord(s: String): Int {
        return s.split(" ").filter { it.length > 0 }.lastOrNull()?.length ?: 0
    }
}