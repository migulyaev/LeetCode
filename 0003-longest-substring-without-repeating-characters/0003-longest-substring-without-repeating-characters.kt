class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var map = hashMapOf<Char, Int>()
        var max = 0
        for (i in 0 until s.length) {
            val symbol = s[i]
            if (map.containsKey(symbol)) {
                val keysToRemove = arrayListOf<Char>()
                val indexToRemove = map[symbol]!!
                map.forEach {
                    if (map[it.key]!! <= indexToRemove) {
                        keysToRemove.add(it.key)
                    }
                }
                keysToRemove.forEach {
                    map.remove(it)
                }
            }
            map.put(symbol, i)
            max = Math.max(max, map.size)
        }
        return max
    }
}