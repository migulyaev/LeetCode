class Solution {
    fun checkIfExist(arr: IntArray): Boolean {
        val set = hashSetOf<Int>()
        for (i in 0 until arr.size) {
            if (set.contains(arr[i] * 2)) return true
            if (arr[i] % 2 == 0 && set.contains(arr[i] / 2)) return true
            set.add(arr[i])
        }
        return false
    }
}