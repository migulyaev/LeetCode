class Solution {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val r1 = arrayListOf<Int>()
        val r2 = arrayListOf<Int>()
        val h1 = hashSetOf<Int>()
        val h2 = hashSetOf<Int>()
        
        for (num in nums1) {
            h1.add(num)
        }
        for (num in nums2) {
            h2.add(num)
        }
        
        h1.forEach {
            if (!h2.contains(it)) {
                r1.add(it)
            }
        }
        h2.forEach {
            if (!h1.contains(it)) {
                r2.add(it)
            }
        }
        return listOf(r1, r2)
    }
}