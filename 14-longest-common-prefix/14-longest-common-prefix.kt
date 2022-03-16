class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var shortestString = ""
        strs.forEach {
            if (it.length == 0) return ""
            if (shortestString.length == 0) {
                shortestString = it
                return@forEach
            }
            if (it.length < shortestString.length) {
                shortestString = it
            }
        }
        
        val result = StringBuilder()
        for (i in 0 until shortestString.length) {
            var append = true
            for (j in 0 until strs.size) {
                if (strs[j][i] != shortestString[i]) {
                    append = false
                    break
                }
            }
            if (!append) {
                break
            }
            result.append(shortestString[i])
        }
        return result.toString()
    }
}