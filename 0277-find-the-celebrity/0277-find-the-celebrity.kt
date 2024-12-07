/* The knows API is defined in the parent class Relation.
      fun knows(a: Int, b: Int) : Boolean {} */

class Solution: Relation() {
    override fun findCelebrity(n: Int) : Int {
        for (i in 0 until n) {
            var knownByEveryone = true
            var knowsNoone = true
            for (k in 0 until n) {
                if (i == k) continue
                if (!knows(k, i)) {
                    knownByEveryone = false
                    break
                }
                if (knows(i, k)) {
                    knowsNoone = false
                    break
                }
            }
            if (knownByEveryone && knowsNoone) return i
        }
        return -1
	}
}