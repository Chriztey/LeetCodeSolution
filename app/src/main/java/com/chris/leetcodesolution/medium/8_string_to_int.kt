package com.chris.leetcodesolution.medium

class StringToInt {

    fun myAtoi(s: String): Int {

        var currentInt = 0
        var input = s.trimStart()

        var stringCheck: Boolean = false

        var modifiedString = if (input.first() == '-') {
            stringCheck = true
            input.drop(1)
        } else {
            input
        }

        println(modifiedString)

        for (char in modifiedString) {

            val tempResult = char - 0

           if (!tempResult.isDigit()) {
                return currentInt
            }
            currentInt = currentInt * 10 + tempResult.digitToInt()

        }

        if (stringCheck) {
            return currentInt * -1
        } else return currentInt

    }

}

fun main() {

    val atoi = StringToInt()

    val result = atoi.myAtoi("-91283472332")

    print(result)

}