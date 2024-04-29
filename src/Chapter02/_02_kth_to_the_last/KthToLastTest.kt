package Chapter02._02_kth_to_the_last

import Utility.LinkedList
import Utility.Node
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class KthToLastTest {
    
    @Test
    fun `should return correct node` () {
        //given
        val linkedList = LinkedList<Int>()
        (0 until 10).forEach{linkedList.append(it)}
        
        //when
        val kthToLast: Node<Int>? = linkedList.kthToLast(7)
        
        //then
        assertEquals(3, kthToLast?.data)
    }
    
    @Test
    fun `should return null if k is bigger than list size` () {
        //given
        val linkedList = LinkedList<Int>()
        (0 until 10).forEach{linkedList.append(it)}
        
        //when
        val kthToLast = linkedList.kthToLast(15)
        
        //then
        assertEquals(null, kthToLast)
    }
}