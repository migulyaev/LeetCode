class Solution {
    fun licenseKeyFormatting(s: String, k: Int): String {
        val result = StringBuilder()
        var counter = 0
        for (i in s.length - 1 downTo 0) {
            if (s[i] == '-') continue
            result.insert(0, s[i].toUpperCase())
            counter++
            if (counter == k) {
                result.insert(0, '-')
                counter = 0
            }
        }
        if (result.startsWith('-')) {
            result.deleteCharAt(0)
        }
        return result.toString()
    }
}