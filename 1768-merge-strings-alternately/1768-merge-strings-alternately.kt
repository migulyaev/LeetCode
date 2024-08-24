class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        var pointerOne = 0
        var pointerTwo = 0
        var result = ""
        while (pointerOne <= word1.length - 1 || pointerTwo <= word2.length - 1) {
            if (pointerOne <= word1.length - 1) {
                result += word1[pointerOne]
                pointerOne++
            }
            if (pointerTwo <= word2.length - 1) {
                result += word2[pointerTwo]
                pointerTwo++
            }
        }
        return result
    }
}