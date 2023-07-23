class Solution {
    fun xorOperation(n: Int, start: Int): Int {
        var result = 0
        for (i in 0 until n) {
            result = result.xor(start + 2 * i)
        }
        return result
    }
}