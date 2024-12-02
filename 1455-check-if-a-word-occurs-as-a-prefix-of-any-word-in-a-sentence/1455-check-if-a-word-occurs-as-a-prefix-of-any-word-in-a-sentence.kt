class Solution {
    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        var i = 0
        var wordIndex = 0
        while (i < sentence.length) {
            while (i < sentence.length && sentence[i] == ' ') i++
            while (i < sentence.length && sentence[i] != ' ') {
                var p = 0
                wordIndex++
                while (i < sentence.length && p < searchWord.length && sentence[i] != ' ') {
                    if (sentence[i] == searchWord[p]) {
                        i++
                        p++
                    } else {
                        while (i < sentence.length && sentence[i] != ' ') i++
                        break
                    }
                }
                if (p == searchWord.length) {
                    return wordIndex
                }
                i++
            }
        }
        return -1
    }
}