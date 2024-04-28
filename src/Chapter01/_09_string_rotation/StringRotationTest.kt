package Chapter01._09_string_rotation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringRotationTest {
    @ParameterizedTest
    @CsvSource(
        "apple, pleap, true",
        "waterbottle, erbottlewat, true",
        "camera, macera, false"
    )
    fun `test isRotation function`(word1: String, word2: String, expected: Boolean) {
        
        val actual = isRotation(word1, word2)
        assertEquals(expected, actual)
    }
}