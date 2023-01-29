class Solution {
    fun minHeightShelves(books: Array<IntArray>, shelfWidth: Int): Int {
        val n = books.size
        val dp = Array<Int>(n + 1)  { Integer.MAX_VALUE }
        dp[0] = 0
        
        for (i in 1..n) {
            var maxHeight = 0
            var widthLeft = shelfWidth
            
            for (j in i-1 downTo(0)) {
                widthLeft -= books[j][0]
                maxHeight = Math.max(maxHeight, books[j][1])
                
                if (widthLeft >= 0) {
                    dp[i] = Math.min(dp[i], dp[j] + maxHeight)
                }
            }
        }
        
        return dp[n]
    }
}