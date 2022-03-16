class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        Arrays.sort(nums2);
        val set = hashSetOf<Int>();
        val setNotExists = hashSetOf<Int>();
        nums1.forEach {
            if (setNotExists.contains(it) || set.contains(it)) return@forEach
            if (nums2.binarySearch(it) < 0) {
                setNotExists.add(it)
            } else {
                set.add(it)
            }
        }
        val result = set.toIntArray()
        result.sort()
        return result
    }
}