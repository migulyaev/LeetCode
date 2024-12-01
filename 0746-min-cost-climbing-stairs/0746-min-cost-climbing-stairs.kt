class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val minCosts = IntArray(cost.size) { -1 }
        minCosts[0] = 0
        minCosts[1] = 0
        calculate(cost, minCosts, cost.size - 1)
        return min(cost.last() + minCosts.last(), cost[cost.size - 2] + minCosts[minCosts.size - 2])
    }
    
    private fun calculate(cost: IntArray, mins: IntArray, index: Int) {
        if (index == 0 || index == 1) {
            return
        }
        if (mins[index] != -1) {
            return
        }
        calculate(cost, mins, index - 1)
        calculate(cost, mins, index - 2)
        val fromTwoStepsDown = mins[index - 2] + cost[index - 2]
        val fromOneStepDown = mins[index - 1] + cost[index - 1]
        mins[index] = min(fromTwoStepsDown, fromOneStepDown)
    }
}