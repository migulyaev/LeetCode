class Solution {
    fun deleteGreatestValue(grid: Array<IntArray>): Int {
        grid.forEach {
            it.sort()
        }
        var sum = 0
        var index = grid.first().size - 1
        while (index >= 0) {
            var max = 0
            for (i in 0 until grid.size) {
                if (grid[i][index] > max) {
                    max = grid[i][index]
                }
            }
            sum += max
            index--
        }
        return sum
    }
}