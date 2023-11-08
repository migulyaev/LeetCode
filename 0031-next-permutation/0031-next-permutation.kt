class Solution {

    fun nextPermutation(nums: IntArray): Unit {
        var index = nums.size - 2
        
        while (index >= 0 && nums[index + 1] <= nums[index]) {
            index--
        }
        
        if (index == -1) {
            nums.reverse()
            return
        }
        
        if (index >= 0) {
            var i = nums.size - 1
            while (nums[i] <= nums[index]) {
                i--
            }
            swap(nums, i, index)
        }
        nums.reverse(index + 1)
    }
    
    private fun IntArray.reverse(from: Int) {
        var fromTemp = from
        var toTemp = size - 1
        while (fromTemp < toTemp) {
            swap(this, fromTemp, toTemp)
            fromTemp++
            toTemp--
        }
    }
    
    private fun swap(nums: IntArray, first: Int, second: Int) {
        val temp = nums[first]
        nums[first] = nums[second]
        nums[second] = temp
    }
}