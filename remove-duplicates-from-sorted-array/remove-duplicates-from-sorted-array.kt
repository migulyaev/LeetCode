class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var left: Int = 1
        var right: Int = 1
        
        if (nums.size < 2) {
            return nums.size
        }
        
        while (right < nums.size) {
            val currentNum = nums[right]
            if (currentNum == nums[left-1]) {
                
            } else {
                nums[left] = currentNum
                left++
            }
            right++
        }
        return left
    }
}