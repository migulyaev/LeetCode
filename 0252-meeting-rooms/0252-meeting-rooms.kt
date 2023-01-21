class Solution {
    fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
        val sortedIntervals = intervals.sortedWith(object: Comparator<IntArray> {
            override fun compare(o1: IntArray?, o2: IntArray?): Int {
                return o1!![0].compareTo(o2!![0])
            }
        })
        for (i in 1 until sortedIntervals.size) {
            if (sortedIntervals[i][0] < sortedIntervals[i-1][1]) {
                return false
            }
        }
        return true
    }
}