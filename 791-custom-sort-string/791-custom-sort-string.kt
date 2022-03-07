class Solution {
    fun customSortString(order: String, s: String): String {
        val map = hashMapOf<Char, Int>()
        val setOrder = hashSetOf<Char>()
        s.forEach {
            val count = map[it]
            if (count == null) {
                map[it] = 1
            } else {
                map[it] = count + 1
            }
        }
        
        order.forEach {
            setOrder.add(it)
        }
        
        var result = ""
        
        order.forEach {
            val countOfSymbolInString = map[it]
            if (countOfSymbolInString != null) {
                for (i in 0 until countOfSymbolInString) {
                    result += it
                }
            }
        }
        
        map.forEach { (k, v) ->
            if (setOrder.contains(k)) return@forEach
            for (i in 0 until v) {
                result += k
            }
        }
        return result
    }
}