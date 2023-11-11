class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 0 }
        var positive = -1
        for (i in 0 until nums.size) {
            if (nums[i] >= 0) {
                positive = i
                break
            }
        }
        
        var negative = if (positive != -1) positive - 1 else nums.size - 1
        
        var counter = 0
        while (positive < nums.size && positive != -1 || negative != -1) {
            if (positive < nums.size && positive != -1 && negative >= 0) {
                if (nums[positive] < abs(nums[negative])) {
                    result[counter] = nums[positive] * nums[positive]
                    positive++
                } else {
                    result[counter] = nums[negative] * nums[negative]
                    negative--
                }
            } else if (positive == nums.size || positive == -1) {
                    result[counter] = nums[negative] * nums[negative]
                    negative--
            } else if (negative < 0) {
                    result[counter] = nums[positive] * nums[positive]
                    positive++
            }
            counter++
        }
        return result
    }
}