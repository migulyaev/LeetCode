class Solution {
    fun checkIfExist(arr: IntArray): Boolean {
        for (i in 0 until arr.size - 1) {
            for (j in i + 1 until arr.size) {
                if (arr[i] == 2 * arr[j] || arr[j] == arr[i] * 2) {
                    return true
                }
            }
        }
        return false
    }
}