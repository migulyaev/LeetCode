class Solution {
    fun findBuildings(heights: IntArray): IntArray {
        var result = arrayListOf<Int>()
        for (i in 0 until heights.size - 1) {
            var isOceanView = true
            for (j in i + 1 until heights.size) {
                if (heights[j] >= heights[i]) {
                    isOceanView = false
                    break
                }
            }
            if (isOceanView) {
                result.add(i)
            }
        }
        result.add(heights.size - 1)
        return result.toIntArray()
    }
}