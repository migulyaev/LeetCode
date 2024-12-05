class Solution {
    
    data class Position(
        val position: Int,
        val letter: Char,
    )
    
    fun canChange(start: String, target: String): Boolean {
        val queue1 = ArrayDeque<Position>()
        val queue2 = ArrayDeque<Position>()
        
        for (i in 0 until start.length) {
            if (start[i] != '_') {
                queue1.addLast(Position(i, start[i]))
            }
        }
        
        for (i in 0 until target.length) {
            if (target[i] != '_') {
                queue2.addLast(Position(i, target[i]))
            }
        }
        
        if (queue1.size != queue2.size) {
            return false
        }
        
        while (queue1.isNotEmpty()) {
            val st = queue1.removeLast()
            val ta = queue2.removeLast()
            if (st.letter != ta.letter) {
                return false
            }
            if (st.letter == 'R') {
                if (st.position > ta.position) return false
            } else {
                if (st.position < ta.position) return false
            }
        }

        return true
    }
    
    private fun findNext(target: String, current: Int): Int {
        for (i in current until target.length) {
            if (target[i] != '_') return i
        }
        return target.length
    }
}