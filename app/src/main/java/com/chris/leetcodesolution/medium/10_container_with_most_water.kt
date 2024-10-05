package com.chris.leetcodesolution.medium

import kotlin.math.max

class ContainerWithMostWater {

    fun maxArea(height: IntArray): Int {
        var maxArea = 0
        var leftPointer = 0
        var rightPointer = height.size - 1

        while (leftPointer < rightPointer) {

            var tempArea = (rightPointer - leftPointer) * minOf(height[leftPointer], height[rightPointer])

            maxArea = max(tempArea, maxArea)

            if (height[leftPointer] < height [rightPointer]) {
                leftPointer ++
            } else rightPointer--

        }

        return maxArea


    }

}

fun main () {

    val cwmw = ContainerWithMostWater()

    val result = cwmw.maxArea(intArrayOf(1,8,6,2,5,4,8,3,7))

    println(result)

}