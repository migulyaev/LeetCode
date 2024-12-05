class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        var visited = hashSetOf<Int>()
        val keys = hashSetOf<Int>()
        rooms[0].forEach {
            keys.add(it)
        }
        visited.add(0)
        
        while (true) {
            var visitedNow = 0
            val gainedKeys = hashSetOf<Int>()
            for (key in keys) {
                if (visited.contains(key)) continue
                visitedNow++
                visited.add(key)
                gainedKeys.addAll(rooms[key])
            }
            keys.addAll(gainedKeys)
            if (visited.size == rooms.size) {
                return true
            }
            if (visitedNow == 0) {
                return false
            }
        }

        return false
    }
}