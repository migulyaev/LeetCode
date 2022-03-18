class Solution {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var minPrice = prices[0]
        var maxPrice = 0
        for (i in 1 until prices.size) {
            if (prices[i] <= minPrice) {
                minPrice = prices[i]
                maxPrice = 0
            } else if (prices[i] >= maxPrice) {
                maxPrice = prices[i]
                if (maxPrice - minPrice > maxProfit) {
                    maxProfit = maxPrice - minPrice
                }
            }
        }
        return maxProfit
    }
}