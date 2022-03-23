class Solution {
    fun isOneEditDistance(s: String, t: String): Boolean {
        if (Math.abs(s.length - t.length) >= 2) {
            return false
        }
        if (s == t) {
            return false
        }
        
        return if (s.length == t.length) {
            isOneEditDistanceEqualLength(s, t)
        } else {
            isOneEditDistanceDiffLength(s, t)
        }
    }
    
    private fun isOneEditDistanceEqualLength(s: String, t: String): Boolean {
        val diffIndexes = arrayListOf<Int>()
        for (i in 0 until s.length) {
            if (s[i] != t[i]) {
                diffIndexes.add(i)
            }
        }
        
        return diffIndexes.size == 1
    }
    
    private fun isOneEditDistanceDiffLength(s: String, t: String): Boolean {
        val greaterString = if (s.length > t.length) s else t
        val smallerString = if (s.length < t.length) s else t
        if (smallerString.length == 0 && greaterString.length != 0) {
            return true
        }
        var i = 0
        var k = 0
        var counter = 0
        while (i < greaterString.length && k < smallerString.length) {
            if (greaterString[i] == smallerString[k]) {
                i++
                k++
                continue
            } else {
                counter++
                i++
                if (counter == 2) {
                    break
                }
            }
        }
        return counter <= 1
    }
}