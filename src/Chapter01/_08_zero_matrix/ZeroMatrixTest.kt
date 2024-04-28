package Chapter01._08_zero_matrix

import Utility.randomIntMatrix
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ZeroMatrixTest {
    
    @Test
    fun `should set 0 to row and column` () {
        // given
        val matrix = randomIntMatrix(3, 3, 1, 9)
        matrix[1][1] = 0
        
        // when
        matrix.setZeros()
        
        //then
        matrix[1].forEach { assertEquals(0, it)}
        assertEquals(0, matrix[0][1])
        assertEquals(0, matrix[1][1])
        assertEquals(0, matrix[2][1])
    }
    
    @Test
    fun `should set zeros when zero is in first col` () {
        // given
        val matrix = randomIntMatrix(3, 3, 1, 9)
        matrix[1][0] = 0
        
        // when
        matrix.setZeros()
        
        //then
        matrix[1].forEach { assertEquals(0, it)}
        assertEquals(0, matrix[0][0])
        assertEquals(0, matrix[1][0])
        assertEquals(0, matrix[2][0])
    }
    
    @Test
    fun `should set zero for all elements` () {
        // given
        val matrix = randomIntMatrix(3, 3, 1, 9)
        (0 .. 2).forEach {matrix[it][it] = 0}
        
        // when
        matrix.setZeros()
        
        //then
        matrix.forEach { row ->
            row.forEach { value ->
                assertEquals(0, value)
            }
        }
    }
}