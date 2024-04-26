package Chapter01._07_rotate_matrix

import Utility.IntMatrix
import Utility.randomIntMatrix
import Utility.returnCopyOf
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class MatrixRotationTest {

    @Test
    fun `should be equal after four rotations`() {
        //given
        val matrix : IntMatrix = randomIntMatrix(m = 3, n = 3, min =  -12, max = 13)
        val copyOfMatrix : IntMatrix = matrix.returnCopyOf()
        matrix contentDeepEquals  copyOfMatrix

        //when
        matrix.rotateBy90().rotateBy90().rotateBy90().rotateBy90()

        // then
        matrix contentDeepEquals  copyOfMatrix
    }
    
     @Test
     fun `should be different after one roation` () {
         //given
         val matrix : IntMatrix = randomIntMatrix(m = 3, n = 3, min =  -12, max = 13)
         val copyOfMatrix : IntMatrix = matrix.returnCopyOf()
         matrix contentEquals copyOfMatrix
         
         //when
         matrix.rotateBy90()
         
         // then
         assertFalse(matrix contentDeepEquals copyOfMatrix)
     }
    
    @Test
    fun `test 2 x 2 rotation` () {
        //given
        val matrix : IntMatrix = randomIntMatrix(m = 2, n = 2, min =  0, max = 7)
        val copyOfMatrix : IntMatrix = matrix.returnCopyOf()
        matrix contentEquals copyOfMatrix
        
        //when
        matrix.rotateBy90()
        
        // then
        assertEquals(copyOfMatrix[0][0], matrix[0][1])
        assertEquals(copyOfMatrix[0][1], matrix[1][1])
        assertEquals(copyOfMatrix[1][0], matrix[0][0])
        assertEquals(copyOfMatrix[1][1], matrix[1][0])
    }
}