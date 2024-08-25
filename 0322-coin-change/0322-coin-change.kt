class Solution {
    val memo = hashMapOf<Int, Int>()
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) {
            return 0
        }
        for (i in 0 until coins.size) {
            val coin = coins[i]
            memo[coin] = 1
        }
        for (i in 0 until amount) {
            calculate(coins, i+1)
        }
        return memo[amount]!!
    }
    
    private fun calculate(coins: IntArray, amount: Int): Int {
        if (memo.containsKey(amount)) {
            return memo[amount]!!
        }
        if (amount <= 0) {
            return -1
        }
        var minValue = Int.MAX_VALUE
        for (i in 0 until coins.size) {
            val coin = coins[i]
            val count = calculate(coins, amount - coins[i])
            if (count == -1) {
                continue
            }
            if (count > 0) {
                val amountOfCoins = count + 1
                if (amountOfCoins < minValue) {
                    minValue = amountOfCoins
                }
            }
        }
        if (minValue == Int.MAX_VALUE) {
            minValue = -1
        }
        memo[amount] = minValue
        return minValue
    }
}