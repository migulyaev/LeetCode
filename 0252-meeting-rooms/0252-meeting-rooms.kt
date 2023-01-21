class Solution {
    fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
        val busyMinutes = hashSetOf<Int>()
        for (interval in intervals) {
            for (i in interval[0] until interval[1]) {
                if (busyMinutes.contains(i)) {
                    return false
                }
                busyMinutes.add(i)
            }
        }
        return true
    }
}