package com.chris.leetcodesolution.hard

import android.util.Log
import kotlin.math.max
import kotlin.math.min

class FindMedianSortedNumbers{



    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

        val shortestArray: IntArray
        val longerArray: IntArray

        if (nums1.size < nums2.size) {
            shortestArray = nums1
            longerArray = nums2
        } else {
            shortestArray = nums2
            longerArray = nums1
        }

        val totalArrayLength = nums1.size + nums2.size
        var startingPointer = 0
        var highPointer = shortestArray.size

        while (startingPointer <= highPointer) {

            val shorterPart = (startingPointer + highPointer) / 2
            val longerPart = ((totalArrayLength + 1) / 2 ) - shorterPart

            val shorterPartLeft = getMax(shortestArray,shorterPart)
            val shorterPartRight = getMin(shortestArray, shorterPart)

            val longerPartLeft = getMax(longerArray, longerPart)
            val longerPartRight = getMin(longerArray, longerPart)

            if (shorterPartLeft <= longerPartRight && longerPartLeft <= shorterPartRight ) {
                if (totalArrayLength % 2 == 0) {
                    val a = maxOf(shorterPartLeft, longerPartLeft)
                    val b = minOf(shorterPartRight, longerPartRight)

                    val median = (a+b) / 2.0

                    return  median

                } else {
                    return maxOf(shorterPartLeft,longerPartLeft)
                }
            }

            if (shorterPartLeft  > longerPartRight ) {

                /*

                halving the search space each time,
                we progressively reduce the range where the solution can exist.
                The number of positions moved may vary (sometimes it may seem to move 2 positions, sometimes 1),
                but that is expected because binary search doesn't move in fixed steps of 1.
                Instead, it moves by halving the range.

                 */

                highPointer = shorterPart - 1
            } else {
                startingPointer = shorterPart + 1
            }



        }

        throw IllegalArgumentException("No solution found")



    }

    private fun getMax(numsArray: IntArray, partition: Int): Double {
        if (partition == 0) {
            return Double.NEGATIVE_INFINITY
        } else {
            return numsArray[partition - 1].toDouble()
        }
    }

    private fun getMin(numsArray: IntArray, partition: Int): Double {
        if (partition == numsArray.size) {
            return Double.POSITIVE_INFINITY
        } else {
            return numsArray[partition].toDouble()
        }
    }
}

fun main() {

    val test = FindMedianSortedNumbers()

    val answer = test.findMedianSortedArrays(
        nums1 = intArrayOf(3,4),
        nums2 = intArrayOf(1,2)
    )

    print(answer)

}