class Solution {
    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        return sentence.split(" ").indexOfFirst { it.startsWith(searchWord) }.takeIf { it >= 0 }?.plus(1) ?: -1
    }
}