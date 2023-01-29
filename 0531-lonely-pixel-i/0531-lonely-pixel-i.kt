class Solution {
    fun findLonelyPixel(picture: Array<CharArray>): Int {
        var count = 0
        for (row in 0 until picture.size) {
            val row = picture[row]
            var wCount = 0
            var bIndex = -1
            var isUnique = true
            for (column in 0 until row.size) {
                if (row[column] == 'W') {
                    wCount++
                } else {
                    if (bIndex == -1) {
                        bIndex = column
                    } else {
                        isUnique = false
                        break
                    }
                }
            }
            if (isUnique && bIndex != -1) {
                var bCountInColumn = 0
                for (row2 in 0 until picture.size) {
                    if (picture[row2][bIndex] == 'B') {
                        bCountInColumn++
                        if (bCountInColumn > 1) {
                            break
                        }
                    }
                }
                if (bCountInColumn == 1) {
                    count++
                }
            } else {
                continue
            }
        }
        return count
    }
}