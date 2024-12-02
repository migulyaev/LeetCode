class Solution {
    fun checkIfExist(arr: IntArray): Boolean {
        val set = hashSetOf<Int>()
        for (i in 0 until arr.size) {
            if (set.contains(0) && arr[i] == 0) return true
            set.add(arr[i])
        }
        for (i in 0 until arr.size) {
            if (arr[i] == 0) continue
            if (set.contains(arr[i] * 2)) return true
            if (arr[i] % 2 == 0 && set.contains(arr[i] / 2)) return true
        }
        return false
    }
}