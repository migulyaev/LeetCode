class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        val currentRow = arrayListOf(1)
        val prevRow = arrayListOf(1)
        for (i in 1..rowIndex) {
            for (j in 0 until currentRow.size) {
                if (j < prevRow.size) {
                    prevRow[j] = currentRow[j]
                } else {
                    prevRow.add(currentRow[j])
                }
            }
            for (j in 1..currentRow.size) {
                if (j == currentRow.size) {
                    currentRow.add(1)
                    continue
                }
                currentRow[j] = prevRow[j - 1] + prevRow[j]
            }
        }
        return currentRow
    }
}