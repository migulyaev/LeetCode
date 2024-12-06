class Solution {
    fun maxCount(banned: IntArray, n: Int, maxSum: Int): Int {
        val bannedSet = hashSetOf<Int>()
        banned.forEach {
            bannedSet.add(it)
        }
        var sum = 0
        var max = 0
        for (i in 1..n) {
            if (bannedSet.contains(i)) {
                continue
            }
            sum += i
            if (sum <= maxSum) max++ else break
        }
        return max
    }
}