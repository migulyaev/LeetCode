class Solution {
    fun findBuildings(heights: IntArray): IntArray {
        val result = arrayListOf<Int>()
        result.add(heights.size - 1)
        var maxSize = heights.last()
        for (i in heights.size - 2 downTo 0) {
            if (heights[i] > maxSize) {
                result.add(i)
                maxSize = heights[i]
            }
        }
        result.sort()
        return result.toIntArray()
    }
}