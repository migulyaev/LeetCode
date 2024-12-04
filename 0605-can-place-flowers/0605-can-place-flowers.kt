class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var left = n
        for (i in 0 until flowerbed.size) {
            if (left == 0) {
                return true
            }
            if (flowerbed.size == 1) {
                if (flowerbed[i] == 0) {
                    left--
                    flowerbed[i] = 1
                }
                continue
            }
            if (i == 0) {
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    left--
                    flowerbed[i] = 1
                }
                continue
            }
            if (i == flowerbed.size - 1) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    left--
                    flowerbed[i] = 1
                }
                continue
            }
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    left--
                    flowerbed[i] = 1
            }
        }
        return left == 0
    }
}