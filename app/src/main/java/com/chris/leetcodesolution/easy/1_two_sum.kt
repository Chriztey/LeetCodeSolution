package com.chris.leetcodesolution.easy

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var seen = HashMap<Int, Int>()

        for (i in nums.indices) {
            val diff = target - nums[i]
            if (seen.containsKey(diff)) {
                return intArrayOf(i, seen[diff]!!)
            } else {
                seen[nums[i]] = i
            }
        }

        throw IllegalArgumentException("No solution found")
    }
}

// Example Below


fun main() {
    val func = TwoSum()
    val result = func.twoSum(
        intArrayOf(2,7,11,15),
        target = 9
    )

    println(result.joinToString("," +
            " "))
}