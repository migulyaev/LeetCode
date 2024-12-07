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
    
    private val dictionary = mapOf(
            '2' to listOf('a', 'b', 'c'),
            '3' to listOf('d', 'e', 'f'),
            '4' to listOf('g', 'h', 'i'),
            '5' to listOf('j', 'k', 'l'),
            '6' to listOf('m', 'n', 'o'),
            '7' to listOf('p', 'q', 'r', 's'),
            '8' to listOf('t', 'u', 'v'),
            '9' to listOf('w', 'x', 'y', 'z'),
    )
    
    private fun get(number: Char): List<Char> {
        return dictionary[number]!!
    }
}