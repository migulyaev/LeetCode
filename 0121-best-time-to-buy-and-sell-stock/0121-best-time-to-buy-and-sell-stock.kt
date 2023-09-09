class Solution {
    fun maxProfit(prices: IntArray): Int {
        var min = 10001
        var maxProfit = 0
        for (i in 0 until prices.size) {
            if (prices[i] < min) {
                min = prices[i]
            } else {
                if (prices[i] - min > maxProfit) {
                    maxProfit = prices[i] - min
                }
            }
        }
        return maxProfit
    }
}