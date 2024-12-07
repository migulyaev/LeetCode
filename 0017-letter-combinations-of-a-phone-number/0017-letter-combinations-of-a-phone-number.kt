class Solution {
    
    private val combinations = arrayListOf<String>()
    
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        combinations(digits, "")
        return combinations
    }
    
    private fun combinations(digits: String, currentString: String) {
        if (digits.isEmpty()) {
            combinations.add(currentString)
            return
        }
        get(digits.first()).forEach {
            combinations(digits.replaceFirstChar { "" }, currentString + it)
        }
    }
    
    private fun get(number: Char): List<Char> {
        return when(number) {
            '2' -> listOf('a', 'b', 'c')
            '3' -> listOf('d', 'e', 'f')
            '4' -> listOf('g', 'h', 'i')
            '5' -> listOf('j', 'k', 'l')
            '6' -> listOf('m', 'n', 'o')
            '7' -> listOf('p', 'q', 'r', 's')
            '8' -> listOf('t', 'u', 'v')
            '9' -> listOf('w', 'x', 'y', 'z')
            else -> throw IllegalStateException("")
        }
    }
}