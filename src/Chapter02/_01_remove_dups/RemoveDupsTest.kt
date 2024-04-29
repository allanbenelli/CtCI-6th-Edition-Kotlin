package Chapter02._01_remove_dups

import Utility.LinkedList
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RemoveDupsTest {
    
    @Test
    fun `should remove duplicates from list with only one uniqe element` () {
        // given
        val linkedList = LinkedList<Int>()
        (0 until 20).forEach{ _ -> linkedList.append(2)}
        
        // when
        linkedList.removeDups()
        
        //then
        assertEquals(1, linkedList.getSize())
        val head = linkedList.nodeAt(0)
        assertEquals(2, head?.data)
        assertEquals(null, head?.next)
        
    }
    
    @Test
    fun `should remove duplicates from list` () {
        // given
        val linkedList = LinkedList<Int>()
        (0 until 20).forEach{linkedList.append(it / 2)}
        
        // when
        linkedList.removeDups()
        
        //then
        assertEquals(10, linkedList.getSize())
        (0 until 10).forEach { it ->
            assertEquals(it, linkedList.nodeAt(it)?.data)
        }
        
    }
}

