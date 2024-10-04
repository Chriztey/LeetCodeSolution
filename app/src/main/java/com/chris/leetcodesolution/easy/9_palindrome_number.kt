package com.chris.leetcodesolution.easy

class PalindromeNumber{

    fun isPalindrome(x: Int): Boolean {

        var currentInt = x
        var reserveHalf = 0

        if (x < 0 ) {
            return false
        }

        if (x > 0 && x % 10 == 0) {
            return false
        }

        while (reserveHalf < currentInt) {
            reserveHalf = reserveHalf * 10 + (currentInt % 10)
            currentInt /= 10
        }

        return reserveHalf == currentInt || reserveHalf/10 == currentInt

    }

}

fun main() {

    val pn = PalindromeNumber()

    val result = pn.isPalindrome(121)

    println(result)

}