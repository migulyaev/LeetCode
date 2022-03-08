class Solution {
    fun nextPermutation(nums: IntArray): Unit {
        var indexOfLastGreatestElement = -1
        for (i in (nums.size-2) downTo 0) {
            if (nums[i] < nums[i+1]) {
                indexOfLastGreatestElement = i
                break
            }
        }
        
        if (indexOfLastGreatestElement != -1) {
            var minPossibleDiff = 100
            var minIndex = -1
            for (i in indexOfLastGreatestElement + 1 until nums.size) {
                if (nums[indexOfLastGreatestElement] < nums[i]) {
                    if (minPossibleDiff > nums[i] - nums[indexOfLastGreatestElement]) {
                        minIndex = i
                        nums[i] - nums[indexOfLastGreatestElement]
                    }
                }
            }
            swap(nums, indexOfLastGreatestElement, minIndex)
        }
        reverse(nums, indexOfLastGreatestElement + 1)
    }
    
    private fun reverse(nums: IntArray, start: Int) {
        var i = start
        var j = nums.size - 1
        while (i < j) {
            swap(nums, i, j)
            i++
            j--
        }
    }
    
    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}