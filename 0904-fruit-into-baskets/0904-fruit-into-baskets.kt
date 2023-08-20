class Solution {
    fun totalFruit(fruits: IntArray): Int {
        val basket = HashMap<Int, Int>()
        var max = 0
        var left = 0
        for (right in 0 until fruits.size) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1)
            while (basket.size > 2) {
                basket.put(fruits[left], basket.get(fruits[left])!! - 1)
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left])
                }
                left++
            }
            max = Math.max(max, right - left + 1)
        }
        return max
    }
}