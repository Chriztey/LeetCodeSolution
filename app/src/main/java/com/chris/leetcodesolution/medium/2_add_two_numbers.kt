package com.chris.leetcodesolution.medium

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        val head = ListNode(0)
        var listOne = l1
        var listTwo = l2
        var leftover = 0

        var current = head

        while (listOne != null || listTwo != null || leftover != 0) {
            val countOne = listOne?.`val` ?: 0
            val countTwo = listTwo?.`val` ?: 0

            val total = countOne + countTwo + leftover
            leftover = total/10

            current.next = ListNode(total%10)

            if (listOne != null) {
                listOne = listOne.next
            }

            if (listTwo != null) {
                listTwo = listTwo.next
            }

            current = current.next!!

        }

        return head.next

    }
}



fun main() {

    val aTN = AddTwoNumbers()

    val result = aTN.addTwoNumbers(
        l1 = ListNode(3).apply { next = ListNode(5) },
        l2 = ListNode(2)
    )

    var current = result

    while (current != null) {
        print(result?.`val`)
        current = current.next
    }


}