class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val MAX_IMPOSSIBLE_VALUE = 10001
        val dp = Array<Int>(amount + 1) { 10001 }
        dp[0] = 0
        for (coin in coins) {
            for (currentAmount in coin..amount) {
                dp[currentAmount] = min(dp[currentAmount], dp[currentAmount - coin] + 1)
            }
        }
        return if (dp[amount] == MAX_IMPOSSIBLE_VALUE) -1 else dp[amount]!!
    }
    
}