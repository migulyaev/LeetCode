/* The knows API is defined in the parent class Relation.
      fun knows(a: Int, b: Int) : Boolean {} */

class Solution: Relation() {
    override fun findCelebrity(n: Int) : Int {
        var potentialCelebrity = 0
        for (i in 1 until n) {
            if (knows(potentialCelebrity, i)) {
                potentialCelebrity = i
            }
        }
        if (isCelebrity(potentialCelebrity, n)) {
            return potentialCelebrity
        }
        return -1
	}
    private fun isCelebrity(i: Int, n: Int): Boolean {
        var isCelebrity = true
        for (k in 0 until n) {
            if (i == k) continue
            if (knows(i, k) || !knows(k, i)) {
                isCelebrity = false
                break
            }
        }
        return isCelebrity
    }
}