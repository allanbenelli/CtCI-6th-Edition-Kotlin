package Chapter01._09_string_rotation


fun isRotation(word1: String, word2: String): Boolean =
    word1.isNotEmpty() && word1.length == word2.length && (word1 + word1).contains(word2)