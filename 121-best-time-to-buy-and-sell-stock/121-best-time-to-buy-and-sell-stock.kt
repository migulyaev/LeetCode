class Solution {
    fun maxProfit(prices: IntArray): Int {
        var min = prices[0]
        var maxProfit = 0
        for (i in 1 until prices.size) {
            if (prices[i] - min >= maxProfit) {
                maxProfit = prices[i] - min
            }
            if (prices[i] < min) {
                min = prices[i]
            }
        }
        return maxProfit
    }
}