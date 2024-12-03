class Solution {
    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        val result = arrayListOf<Int>()
        for (i in left..right) {
            if (isSelfDividing(i)) {
                result.add(i)
            }
        }
        return result
    }
    
    private fun isSelfDividing(number: Int): Boolean {
        var n = number
        while (n > 0) {
            val digit = n % 10
            if (digit == 0 || number % digit != 0) {
                return false
            }
            n /= 10
        }
        return true
    }
}