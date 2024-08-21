class Solution {
    fun getSum(a: Int, b: Int): Int {
        var aTemp = a
        var bTemp = b
        var c = 0
        while (bTemp != 0) {
            c = aTemp and bTemp
            aTemp = aTemp xor bTemp
            bTemp = c shl 1
        }
        return aTemp
    }
    
}