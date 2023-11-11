class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        val result = arrayListOf<Int>()
        var positive = -1
        for (i in 0 until nums.size) {
            if (nums[i] >= 0) {
                positive = i
                break
            }
        }
        
        var negative = if (positive != -1) positive - 1 else nums.size - 1
        
        while (positive < nums.size && positive != -1 || negative != -1) {
            if (positive < nums.size && positive != -1 && negative >= 0) {
                if (nums[positive] < abs(nums[negative])) {
                    result.add(nums[positive] * nums[positive])
                    positive++
                } else {
                    result.add(nums[negative] * nums[negative])
                    negative--
                }
            } else if (positive == nums.size || positive == -1) {
                    result.add(nums[negative] * nums[negative])
                    negative--
            } else if (negative < 0) {
                    result.add(nums[positive] * nums[positive])
                    positive++
            }
        }
        return result.toIntArray()
    }
}