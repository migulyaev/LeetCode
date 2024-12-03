class Solution {
    fun maxArea(height: IntArray): Int {
        var i = 0
        var k = height.size - 1
        var max = 0
        while (i != k) {
            max = max((k - i) * min(height[k],height[i]), max)
            if (height[k] < height[i]) {
                k--
            } else {
                i++
            }
        }
        return max
    }
}