class Solution {
    
    private val result = arrayListOf<String>()
    private var digits: String? = null

    fun letterCombinations(digits: String): List<String> {
        result.clear()
        this.digits = digits
        if (digits.length == 0) return emptyList()
        getAllCombinations(0, StringBuilder())
        return result
    }
    
    private fun getAllCombinations(i: Int, path: StringBuilder) {
        if (path.length == digits!!.length) {
            result.add(path.toString())
            return
        }
        
        for (char in getLetters(digits!![i])) {
            path.append(char)
            getAllCombinations(i+1, path)
            path.deleteCharAt(path.length - 1)
        }
    }
    
    private fun getLetters(digit: Char) = when (digit) {
        '2' -> listOf('a', 'b', 'c')
        '3' -> listOf('d', 'e', 'f')
        '4' -> listOf('g', 'h', 'i')
        '5' -> listOf('j', 'k', 'l')
        '6' -> listOf('m', 'n', 'o')
        '7' -> listOf('p', 'q', 'r', 's')
        '8' -> listOf('t', 'u', 'v')
        '9' -> listOf('w', 'x', 'y', 'z')
        else -> emptyList()
    }
}