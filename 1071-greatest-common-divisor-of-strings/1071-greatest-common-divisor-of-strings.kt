class Solution {
    fun gcdOfStrings(str1: String, str2: String): String {
        val len1 = str1.length
        val len2 = str2.length
        for (i in (min(len1, len2) downTo 1)) {
            if (valid(str1, str2, i)) {
                return str1.substring(0, i)
            }
        }
        return ""
    }
    
    private fun valid(str1: String, str2: String, length: Int): Boolean {
        return if (str1.length % length > 0 || str2.length % length > 0) {
            false
        } else {
            val base = str1.substring(0, length)
            str1.replace(base, "").isEmpty() && str2.replace(base, "").isEmpty()
        }
    }
}