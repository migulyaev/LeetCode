class Solution {
    fun canMakeSubsequence(str1: String, str2: String): Boolean {
        var i1 = 0
        var i2 = 0
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++
                i2++
                continue
            } else if (str1[i1].nextChar() == str2[i2]) {
                i1++
                i2++
                continue
            } else {
                i1++
            }
        }
        return i2 == str2.length
    }
    
    private fun Char.nextChar(): Char {
        return if (this == 'z') 'a' else this + 1
    }
}