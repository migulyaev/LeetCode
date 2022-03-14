class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var min = 0
        var max = nums.size - 1
        var med = 0
        while (min <= max) {
            val med = min + (max - min) / 2
            val value = nums[med]
            if (value == target) {
                return med
            }
            if (value > target) {
                max = med - 1
            } else {
                min = med + 1
            }
        }
        
        return -1
    }
}