class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        var i = 0
        var k = 0
        var result = ""
        while (i < word1.length || k < word2.length) {
            if (i < word1.length) {
                result += word1[i]
                i++
            }
            if (k < word2.length) {
                result += word2[k]
                k++
            }
        }
        return result
    }
}