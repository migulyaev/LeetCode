class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = arrayListOf<IntArray>()
        if (intervals.isEmpty()) {
            return arrayOf(newInterval)
        }
        var i = 0
        var isNewIntervalInserted = false
        while (i < intervals.size) {
            if (isNewIntervalInserted) {
                result.add(intervals[i])
                i++
                continue
            }
            if (newInterval[0] > intervals[i][1]) {
                result.add(intervals[i])
                i++
                continue
            } else {
                val left = Math.min(newInterval[0], intervals[i][0])
                if (newInterval[1] < intervals[i][1]) {
                    if (newInterval[1] >= intervals[i][0]) {
                        result.add(intArrayOf(left, intervals[i][1]))
                        i++
                    } else {
                        result.add(newInterval)
                    }
                    isNewIntervalInserted = true
                } else {
                    while (i < intervals.size && newInterval[1] > intervals[i][1]) {
                        i++
                    }
                    if (i == intervals.size) {
                        result.add(intArrayOf(left, newInterval[1]))
                        isNewIntervalInserted = true
                    } else {
                        if (newInterval[1] < intervals[i][0]) {
                            result.add(intArrayOf(left, newInterval[1]))
                            isNewIntervalInserted = true
                        } else {
                            result.add(intArrayOf(left, intervals[i][1]))
                            isNewIntervalInserted = true
                            i++
                        }
                    }
                }
            }
        }
        if (!isNewIntervalInserted) {
            result.add(newInterval)
        }
        return result.toTypedArray()
    }
}