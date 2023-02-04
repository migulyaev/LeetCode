class Solution {
    fun kthFactor(n: Int, k: Int): Int {
        val factors = arrayListOf<Int>()
        var i = 1
        while (i <= n) {
            if (n % i == 0) {
                factors.add(i)
            }
            if (i >= n/2 && i != n) {
                i = n
            } else {
                i++
            }
        }
        if (factors.size >= k) {
            return factors[k-1]
        } else {
            return -1
        }
    }
}