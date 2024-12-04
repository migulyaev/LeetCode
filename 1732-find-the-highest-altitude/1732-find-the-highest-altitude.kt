class Solution {
    fun largestAltitude(gain: IntArray): Int {
        var curr = 0
        var max = 0
        for (g in gain) {
            curr += g
            max = max(max, curr)
        }
        return max
    }
}