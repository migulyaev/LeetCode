class Solution {
    fun addBinary(a: String, b: String): String {
        var aIndex = a.length - 1
        var bIndex = b.length - 1
        var carry = 0
        val result = StringBuilder()
        while (aIndex >= 0 || bIndex >= 0) {
            val first = if (aIndex >= 0) a[aIndex] - '0' else 0
            val second = if (bIndex >= 0) b[bIndex] - '0' else 0
            val sum = first + second + carry
            val resultDigit = when(sum) {
                0 -> {
                    carry = 0
                    0
                }
                1 -> {
                    carry = 0
                    1
                }
                2 -> {
                    carry = 1
                    0
                }
                3 -> {
                    carry = 1
                    1
                }
                else -> throw IllegalStateException(sum.toString())
            }
            result.append(resultDigit)
            aIndex--
            bIndex--
        }
        if (carry == 1) {
            result.append(carry)
        }
        return result.reverse().toString()
    }
}