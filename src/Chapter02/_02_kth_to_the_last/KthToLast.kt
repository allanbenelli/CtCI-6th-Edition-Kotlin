package Chapter02._02_kth_to_the_last

import Utility.LinkedList
import Utility.Node

internal fun <T> LinkedList<T>.kthToLast(k: Int) : Node<T>? {
    if (getSize() < k) return null
    return kthToLastInternal(this.nodeAt(0), k).first
}

private fun <T> LinkedList<T>.kthToLastInternal(first: Node<T>?, k: Int) : Pair<Node<T>?, Int> {
    if (first == null) return null to 0
    val recursive = kthToLastInternal(first.next, k);
    val res = recursive.second + 1;
    return (recursive.first ?: if (res == k) first else null) to res
    
}