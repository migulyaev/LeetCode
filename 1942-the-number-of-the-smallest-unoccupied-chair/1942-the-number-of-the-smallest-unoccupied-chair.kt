class Solution {
    fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
        val targetFriend = times[targetFriend]

        val sortedTimes = times.sortedBy { it[0] }

        val freeChairs = PriorityQueue<Int>()
        for (i in 0 until 10000) {
            freeChairs.add(i)
        }

        val occupiedChairsByDepartureTime = hashMapOf<Int, List<Int>>()

        val arrivalToDeparture = hashMapOf<Int, Int>()
        for (i in 0 until sortedTimes.size) {
            arrivalToDeparture[sortedTimes[i][0]] = sortedTimes[i][1]
        }
        
        for (i in 1..100000) {
            if (occupiedChairsByDepartureTime.containsKey(i)) {
                // free chair
                val chairPosition = occupiedChairsByDepartureTime[i]!!.forEach {
                    freeChairs.add(it)
                }
                occupiedChairsByDepartureTime.remove(i)
            }
            if (targetFriend[0] == i) {
                return freeChairs.poll()
            }
            if (arrivalToDeparture.containsKey(i)) {
                // put friend to free chair
                val freeChair = freeChairs.poll()
                val allOccupied = occupiedChairsByDepartureTime[arrivalToDeparture[i]!!] ?: emptyList()
                val combined = arrayListOf<Int>().apply {
                    addAll(allOccupied)
                    add(freeChair)
                }
                occupiedChairsByDepartureTime[arrivalToDeparture[i]!!] = combined                
            }
        }
        return 0
    }
}