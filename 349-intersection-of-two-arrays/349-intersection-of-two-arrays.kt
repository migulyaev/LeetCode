class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        Arrays.sort(nums1); // O(nlog(N))
        Arrays.sort(nums2); // O(nlog(N))
        var x = 0
        var y = 0
        val result = arrayListOf<Int>()
        while (x < nums1.size && y < nums2.size) {
            if (nums1[x] > nums2[y]) {
                y++
            } else if (nums1[x] < nums2[y]) {
                x++
            } else {
                if (result.size == 0 || result.last() != nums1[x]) {
                    result.add(nums1[x])
                }
                x++
                y++
            }
        }
        return result.toIntArray()
    }
}