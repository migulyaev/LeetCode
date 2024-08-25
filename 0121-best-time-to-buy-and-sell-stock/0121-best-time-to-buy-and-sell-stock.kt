class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = 10001
        var maxProfit = 0
        for (i in 0 until prices.size) {
            if (prices[i] < minPrice) {
                minPrice = prices[i]
            } else {
                maxProfit = max(maxProfit, prices[i] - minPrice)
            }
        }
        
        return maxProfit
    }
}