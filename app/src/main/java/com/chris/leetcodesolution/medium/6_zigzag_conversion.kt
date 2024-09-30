package com.chris.leetcodesolution.medium

class ZigZagConversion {

    fun convert(s: String, numRows: Int): String {

        if (numRows == 1 || s.length == numRows) {
            return s
        }



        var rows : MutableList<ArrayList<Char>> = mutableListOf()

        repeat(numRows, {rows.add(ArrayList<Char>())})

        var index = 0
        var step = 1


        var conversionResult: String = ""

        for (char in s) {

            rows[index].add(char)

            if (index == 0) {
                step = 1
            } else if (index == numRows - 1) {
                step = -1
            }

            index += step

        }

        for (numR in rows) {

            val temp = numR.joinToString(separator = "")
            conversionResult += temp
        }

        return conversionResult

    }

}


fun main() {
    val zz = ZigZagConversion()

    val result = zz.convert("ab", 1)
    println(result)

}