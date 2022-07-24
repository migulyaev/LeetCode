class Solution {
    
    private val checkedValues = hashSetOf<Int>()
    
    fun isHappy(n: Int): Boolean {
        return isHappyImpl(n, sumOfSquares(n))
    }
    
    private fun sumOfSquares(n: Int): Int {
        var sum = 0
        var temp = n
        while (temp > 0) {
            sum += (temp % 10)*(temp%10)
            temp /= 10
        }
        return sum
    }
    
    private fun isHappyImpl(n: Int, sumOfSquaresPrev: Int): Boolean {
        if (sumOfSquaresPrev == 1) {
            return true
        }
        if (n == sumOfSquaresPrev) {
            return false
        }
        if (checkedValues.contains(sumOfSquaresPrev)) {
            return false
        }
        checkedValues.add(sumOfSquaresPrev)
        return isHappyImpl(n, sumOfSquares(sumOfSquaresPrev))
    }
}