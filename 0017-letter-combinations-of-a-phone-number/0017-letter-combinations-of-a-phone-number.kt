class Solution {
    
    private val combinations = arrayListOf<String>()
    private lateinit var digits: String
    
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        this.digits = digits
        combinations(0, StringBuilder())
        return combinations
    }
    
    private fun combinations(i: Int, builder: StringBuilder) {
        if (i == digits.length) {
            combinations.add(builder.toString())
            return
        }
        get(digits[i]).forEach {
            builder.append(it)
            combinations(i + 1, builder)
            builder.deleteCharAt(i)
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