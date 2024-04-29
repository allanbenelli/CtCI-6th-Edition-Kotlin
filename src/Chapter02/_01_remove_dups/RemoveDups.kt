package Chapter02._01_remove_dups

import Utility.LinkedList

fun <T> LinkedList<T>.removeDups() {
    var current = this.nodeAt(0)
    while (current != null) {
        var runner = current
        while (runner?.next != null) {
            if (runner.next?.data == current.data) {
                this.removeAfter(runner) //runner.next = runner.next?.next
            } else {
                runner = runner.next
            }
        }
        current = current.next
    }
}
