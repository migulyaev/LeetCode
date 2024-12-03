class Solution {
    fun addSpaces(s: String, spaces: IntArray): String {
        var result = StringBuilder()
        var i = 0
        var k = 0
        while (i < s.length || k < spaces.size) {
            if (k == spaces.size) {
                result.append(s[i])
            } else {
                if (i == spaces[k]) {
                    result.append(' ')
                    k++
                }
                result.append(s[i])
            }
            i++
        }
        return result.toString()
    }
}