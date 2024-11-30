class Solution {
    fun tribonacci(n: Int): Int {
        var t0 = 0
        var t1 = 1
        var t2 = 1
        if (n == 0) {
            return 0
        }
        if (n == 1 || n == 2) {
            return 1
        }
        for (i in 3..n) {
            var tribo = t0 + t1 + t2
            t0 = t1
            t1 = t2
            t2 = tribo
        }
        return t2
    }
}