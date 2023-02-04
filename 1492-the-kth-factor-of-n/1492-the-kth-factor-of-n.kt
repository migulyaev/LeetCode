class Solution {
    fun kthFactor(n: Int, k: Int): Int {
        val factors = arrayListOf<Int>()
        for (i in 1..n) {
            if (n % i == 0) {
                factors.add(i)
            }
        }
        if (factors.size >= k) {
            return factors[k-1]
        } else {
            return -1
        }
    }
}