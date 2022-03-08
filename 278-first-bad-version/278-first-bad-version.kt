/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var right = n
        var left = 1
        while (right > left) {
            val median = left + (right - left) / 2
            val medianIsBad = isBadVersion(median)
            if (medianIsBad) {
                right = median
            } else {
                left = median + 1
            }
        }
        return left
	}
}