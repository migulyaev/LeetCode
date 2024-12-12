class Solution {
    fun pickGifts(gifts: IntArray, k: Int): Long {
        for (i in 0 until k) {
            val maxIndex = maxIndex(gifts)
            val sqrt = Math.sqrt(gifts[maxIndex].toDouble()).toInt()
            gifts[maxIndex] = sqrt
        }
        return gifts.map { it.toLong() }.sum()
    }
    
    private fun maxIndex(arr: IntArray): Int {
        var maxIndex = 0
        for (i in 0 until arr.size) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i
            }
        }
        return maxIndex
    }
}