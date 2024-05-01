package Utility


data class Node<T>(var data: T, var next: Node<T>? = null, var prev: Node<T>? = null, ) {
    override fun toString(): String {
        return "$data${next?.let { " -> ${it}" } ?: ""}"
    }
}

class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    var size = 0
        private set
    
    fun isEmpty(): Boolean {
        return size == 0
    }
    
    override fun toString(): String = if (isEmpty()) "Empty List" else head.toString()
    
    fun push(data: T): LinkedList<T> {
        head = Node(data = data, next = head)
        head?.next?.prev = head
        if (tail == null) tail = head
        size++
        return this
    }
    
    fun append(data: T): LinkedList<T> {
        if (isEmpty()) return push(data)
        tail?.next = Node(data = data, prev = tail)
        tail = tail?.next
        size++
        return this
    }
    
    fun nodeAt(index: Int): Node<T>? {
        var current = head
        var currentIndex = 0
        
        while (current != null && currentIndex < index) {
            current = current.next
            currentIndex++
        }
        return current
    }
    
    fun insert(data: T, afterNode: Node<T>): Node<T> {
        if (tail == afterNode) {
            append(data)
            return tail!!
        }
        
        val newNode = Node(data = data, prev = afterNode, next = afterNode.next)
        afterNode.next?.prev = newNode
        afterNode.next = newNode
        size++
        return newNode
    }
    
    fun pop(): T? {
        if (isEmpty()) return null
        val current = head
        head = head?.next
        head?.prev = null
        size--
        if (isEmpty()) tail = null
        return current?.data
    }
    
    fun removeLast(): T? {
        if (isEmpty()) return null
        val current = tail
        tail = tail?.prev
        tail?.next = null
        size--
        if (isEmpty()) head = null
        return current?.data
    }
    
    fun removeAfter(node: Node<T>): T? {
        val result = node.next
        node.let { size-- }
        if (tail == result) {
            tail = node
            node.next = null
        } else {
            node.next = node.next?.next
            node.next?.prev = node
        }
        return result?.data
    }

}
