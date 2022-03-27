class Solution {
    fun totalFruit(fruits: IntArray): Int {
        var maxCount = 0
        var count = 0
        var index1 = -1
        var type1 = -1
        var countOfType1 = 0
        var index2 = -1
        var type2 = -1
        var countOfType2 = 0
        var count1InRow = 0
        var count2InRow = 0
        for (i in 0 until fruits.size) {
            if (type1 == -1) {
                count++
                countOfType1++
                index1 = i
                type1 = fruits[i]
                count1InRow++
                continue
            }
            if (type2 == -1) {
                if (type1 != fruits[i]) {
                    type2 = fruits[i]
                    index2 = i
                    countOfType2++
                    count2InRow++
                    count1InRow = 0
                } else {
                    index1 = i
                    countOfType1++
                    count1InRow++
                }
                count++
                continue
            }
            if (fruits[i] == type1 || fruits[i] == type2) {
                if (fruits[i] == type1) {
                    index1 = i
                    countOfType1++
                    count1InRow++
                    count2InRow = 0
                } else {
                    index2 = i
                    countOfType2++
                    count2InRow++
                    count1InRow = 0
                }
                count++
                continue
            } else {
                if (count > maxCount) {
                    maxCount = count
                }
                if (index1 < index2) {
                    count = count2InRow + 1
                    countOfType1 = 1
                    index1 = i
                    type1 = fruits[i]
                    count1InRow++
                    count2InRow = 0
                } else {
                    count = count1InRow + 1
                    countOfType2 = 1
                    index2 = i
                    type2 = fruits[i]
                    count1InRow = 0
                    count2InRow++
                }
            }
        }
        if (count > maxCount) {
            maxCount = count
        }
        return maxCount
    }
}