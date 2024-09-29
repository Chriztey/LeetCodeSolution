package com.chris.leetcodesolution.medium

import android.util.Log

class LengthOfLongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {

        val seenChar = HashMap<Char,Int> ()
        var leftPointer = 0
        var substringLength = 0

        for (index in s.indices) {
            val currentChar = s[index]
            println(currentChar)

            if (seenChar.containsKey(currentChar) && seenChar[currentChar]!! >= leftPointer) {
                leftPointer = seenChar[currentChar]!! + 1
            } else {

                val tempLength = (index - leftPointer) + 1

                if (tempLength > substringLength) {
                    substringLength = tempLength
                }

                println(substringLength)
            }

            seenChar[currentChar] = index

        }

        return substringLength


    }
}

fun main () {
    val lols = LengthOfLongestSubstring()
    val testing = lols.lengthOfLongestSubstring(
        "nfpdmpi"
    )

    print(testing)
}

