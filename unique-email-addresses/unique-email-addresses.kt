class Solution {
    fun numUniqueEmails(emails: Array<String>): Int {
        val result = hashSetOf<String>()
        emails.forEach {
            val splitted = ArrayList(it.split('@'))
            if (splitted.size != 2) {
                return@forEach
            }
            val index = splitted[0].indexOfFirst { it == '+' }
            if (index != -1) {
                splitted[0] = splitted[0].substring(0, index)
            }
            splitted[0] = splitted[0].replace(".", "")
            result.add(splitted[0] + "@" + splitted[1])
        }
        return result.size
    }
}