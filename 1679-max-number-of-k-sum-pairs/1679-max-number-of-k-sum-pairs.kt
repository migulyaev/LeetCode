class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        var total = 0
        val map = hashMapOf<Int, Int>()
        nums.forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        
        map.keys.forEach {
            val firstCount = map[it]!!

            val requiredNum = k - it
            val secondCount = map[requiredNum]

            if (firstCount > 0 && secondCount != null && secondCount > 0) {
                if (it != requiredNum) {
                    val pairs = minOf(firstCount, secondCount)
                    total += pairs
                    map[it] = firstCount - pairs
                    map[requiredNum] = secondCount - pairs
                } else {
                    val pairs = firstCount / 2
                    total += pairs
                    map[it] = firstCount - pairs * 2
                }
            }
        }
        return total
    }
}