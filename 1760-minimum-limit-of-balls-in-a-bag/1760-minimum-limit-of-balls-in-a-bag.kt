class Solution {
    fun minimumSize(nums: IntArray, maxOperations: Int): Int {
        var left = 1
        var right = 0
        for (num in nums) {
            right = max(right, num)
        }
        
        while (left < right) {
            val middle = (left + right) / 2
            if (isPossible(middle, nums, maxOperations)) {
                right = middle
            } else {
                left = middle + 1
            }
        }
        return left
    }
    
    private fun isPossible(maxBallsInBag: Int, nums: IntArray, maxOperations: Int): Boolean {
        var totalOperations = 0
        for (num in nums) {
            val operations = (ceil(num / maxBallsInBag.toDouble()) - 1).toInt()
            totalOperations += operations
            if (totalOperations > maxOperations) {
                return false
            }
        }
        return true
    }
}