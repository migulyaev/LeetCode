class Solution {
    fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
        var i = 0
        while (i < arr.size) {
            var piecesIndexToPick = 0
        while (i < arr.size) {
            var piecesIndexToPick = 0
            var needToIterate = true
            while (piecesIndexToPick < pieces.size && needToIterate) {
                if (pieces[piecesIndexToPick][0] == arr[i]) {
                        needToIterate = false
                    } else {
                        piecesIndexToPick++
                    }
                }
                if (piecesIndexToPick == pieces.size) {
                    return false
                }
                for (j in 0 until pieces[piecesIndexToPick].size) {
                    if (pieces[piecesIndexToPick][j] != arr[i]) {
                        return false
                    } else {
                        i++
                    }
                }
            }
        }
        return true
    }
}