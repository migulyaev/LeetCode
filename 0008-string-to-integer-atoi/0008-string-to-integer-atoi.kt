class Solution {
    fun myAtoi(s: String): Int {
        val trimmedString = s.trim()
        if (trimmedString.isEmpty()) {
            return 0
        }
        var i = 0
        val multiplier = if (trimmedString.first() == '-') {
            i++
            -1
        } else if (trimmedString.first() == '+') {
            i++
            1
        } else {
            1
        }
        
        if (i == trimmedString.length) {
            return 0
        }
        
        val maxValue = Int.MAX_VALUE
        val minValue = Int.MIN_VALUE
        var resultUnsigned = 0

        while (i < trimmedString.length && trimmedString[i].isDigit()) {
            if (multiplier > 0) {
                when {
                    resultUnsigned < maxValue / 10 -> {
                        resultUnsigned = resultUnsigned * 10 + trimmedString[i].toString().toInt()
                    }
                    resultUnsigned > maxValue / 10 -> {
                        return maxValue
                    }
                    resultUnsigned == maxValue / 10 -> {
                        if (trimmedString[i] == '8' || trimmedString[i] == '9') {
                            return maxValue
                        }
                        resultUnsigned = resultUnsigned * 10 + trimmedString[i].toString().toInt()
                    }
                }
            } else {
                when {
                    resultUnsigned > maxValue / 10 -> {
                        return minValue
                    }
                    resultUnsigned < maxValue / 10 -> {
                        resultUnsigned = resultUnsigned * 10 + trimmedString[i].toString().toInt()
                    }
                    resultUnsigned == maxValue / 10 -> {
                        if (trimmedString[i] == '9' || trimmedString[i] == '8') {
                            return minValue
                        }
                        resultUnsigned = resultUnsigned * 10 + trimmedString[i].toString().toInt()
                    }
                }
            }
            i++
        }
        
        return resultUnsigned * multiplier
    }
}