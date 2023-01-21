class Solution {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val actualR = mat.size
        val actualC = mat[0].size
        if (actualR * actualC != r * c) {
            return mat
        }
        
        val newMatrix = Array(r) { IntArray(c) { 0 } }
        
        var oldR = 0
        var oldC = 0
        var newR = 0
        var newC = 0
        while (!(newR == r && newC == 0)) {
            newMatrix[newR][newC] = mat[oldR][oldC]
            if (newC == c-1) {
                newC = 0
                newR++
            } else {
                newC++
            }
            if (oldC == actualC - 1) {
                oldC = 0
                oldR++
            } else {
                oldC++
            }
        }
        return newMatrix
    }
}