class Solution {
    fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        var extraStudents = extraStudents
        val priorityQueue = PriorityQueue<Gain>(Comparator { first, second ->
                when {
        first.gain == second.gain -> 0         // If values are equal
        second.gain < first.gain -> -1         // If first value is smaller
        else -> 1           // If first value is larger
    }
        })
        for (classs in classes) {
            priorityQueue.offer(
                Gain(
                    calculateGain(classs[0], classs[1]),
                    classs[0],
                    classs[1],
                )
            )
        }

        while (extraStudents > 0) {
            val next = priorityQueue.remove()!!
            priorityQueue.offer(
                next.copy(
                    gain = calculateGain(next.passStudents + 1, next.totalStudents + 1),
                    passStudents = next.passStudents + 1,
                    totalStudents = next.totalStudents + 1,
                )
            )
            extraStudents--
        }

        var ratiosSum = 0.0
        while (priorityQueue.isNotEmpty()) {
            val classs = priorityQueue.remove()!!
            ratiosSum += classs.passStudents.toDouble() / classs.totalStudents
        }
        return ratiosSum / classes.size
    }
    
    private data class Gain(
        val gain: Double,
        val passStudents: Int,
        val totalStudents: Int,
    )
    
    private fun calculateGain(pass: Int, total: Int): Double {
        return ((pass + 1).toDouble() / (total + 1)) - pass.toDouble() / total
    }
}