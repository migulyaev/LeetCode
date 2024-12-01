class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val minCosts = IntArray(cost.size) { -1 }
        minCosts[0] = 0
        minCosts[1] = 0
        for (i in 2 until cost.size) {
            minCosts[i] = min(minCosts[i - 2] + cost[i - 2], minCosts[i - 1] + cost[i - 1])
        }
        return min(cost.last() + minCosts.last(), cost[cost.size - 2] + minCosts[minCosts.size - 2])
    }
    
}