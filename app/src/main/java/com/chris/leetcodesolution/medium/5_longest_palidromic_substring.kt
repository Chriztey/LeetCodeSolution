package com.chris.leetcodesolution.medium



class LongestPalidromicSubstring {

    fun longestPalindrome(s: String): String {

        var leftPointer: Int = 0
        var rightPointer: Int = 0

        var result = ""

        fun expandPointer(left: Int, right: Int): String {

            var left = left
            var right = right

            while (left >= 0 && right < s.length && s[left] == s[right] ) {
                left -= 1
                right += 1
            }

            return s.substring(left + 1,right)
        }

        for (i in s.indices) {

            val subsOne = expandPointer(i,i)
            if (subsOne.length > result.length) {
                result = subsOne
            }

            val subsTwo = expandPointer(i, i+1)
            if (subsTwo.length > result.length) {
                result = subsTwo
            }

        }

        return  result


    }

}

fun main() {
    val lps = LongestPalidromicSubstring()

    val result = lps.longestPalindrome("bebbe")
    println(result)


}

