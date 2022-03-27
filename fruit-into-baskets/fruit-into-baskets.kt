class Solution {
    fun totalFruit(fruits: IntArray): Int {
        var maxCount = 0
        for (i in 0 until fruits.size) {
            var type1 = -1
            var type2 = -1
            var count = 0
            for (k in i until fruits.size) {
                if (i == k) {
                    type1 = fruits[i]
                    count++
                    continue
                }
                if (type2 == -1) {
                    if (fruits[k] == type1) {
                        count++
                        continue
                    } else {
                        type2 = fruits[k]
                        count++
                        continue
                    }
                }
                if (fruits[k] != type1 && fruits[k] != type2) {
                    break
                }
                count++
            }
            if (count > maxCount) {
                maxCount = count
            }
        }
        return maxCount
    }
}