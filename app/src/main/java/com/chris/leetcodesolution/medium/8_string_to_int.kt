package com.chris.leetcodesolution.medium

import kotlin.math.pow

class StringToInt {

    fun myAtoi(s: String): Int {

        var currentInt = 0
        var positiveNegative = 1
        var input = s.trimStart()


        var max = Int.MAX_VALUE
        var min = Int.MIN_VALUE

        println("max = $max min = $min")

        var modifiedString = ""

        if (input.isNotBlank()) {

            when (input.first()) {
                '-' -> {
                    positiveNegative *= -1
                    modifiedString = input.drop (1)
                }

                '+' -> {
                    positiveNegative *= 1
                    modifiedString = input.drop (1)
                }

                else -> modifiedString = input
            }
        } else {
            return 0
        }

        println("positv/nega = $positiveNegative")

        for (char in modifiedString) {
            if (!char.isDigit()) {
                break // Stop processing if a non-digit character is encountered
            }

            val digit = char - '0'

            // Check for potential overflow before updating currentInt
            if (currentInt > (max - digit) / 10) {
                return if (positiveNegative == 1) max else min
            }

            currentInt = currentInt * 10 + digit
            println("current int = $currentInt")
        }
        
        return currentInt * positiveNegative

    }

}

fun main() {

    val atoi = StringToInt()

    val result = atoi.myAtoi("2147483646")

    print(result)

}