package com.chris.leetcodesolution.medium

import kotlin.math.pow
import kotlin.math.truncate


class ReverseInteger {
    fun reverse(x: Int): Int {

        var input = x

        val maxInt = (2.0).pow(31).toInt() - 1
        val minInt = -(2.0.pow(31)).toInt()
        var reverse = 0

        while ( input != 0) {

            if (reverse > maxInt/10 || reverse < minInt/10) {
                return 0
            }
            val digit = input % 10

            reverse = reverse * 10 + digit
            input = truncate((input/10).toDouble()).toInt()
        }
        return reverse
    }
}

fun main() {

    val ri = ReverseInteger()
    val result = ri.reverse(1534236469)

    print(result.toString())

}