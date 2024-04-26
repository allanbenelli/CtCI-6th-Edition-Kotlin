package Chapter01._07_rotate_matrix

import Utility.IntMatrix
import Utility.isSquare
import Utility.print
import Utility.randomIntMatrix

fun main(args: Array<String>) {
    val randomIntMatrix = randomIntMatrix(m = 4, n = 4, min = 0, max = 13)
    randomIntMatrix.print()
    randomIntMatrix.rotateBy90()
    randomIntMatrix.print()
}

fun IntMatrix.rotateBy90() : IntMatrix {
    if (!this.isSquare()) throw IllegalArgumentException("not a square")
    val n = this.size
    for (i in 0 until n / 2) {
        for (j in i until n - 1 - i) {
            val temporaryTop = this[i][j] // save top left
            // move bottom left to top
            this[i][j] = this[n - 1 - j][j]
            // move bottom right to bottom left
            this[n - 1 - j][i] = this[n - 1 - i][n - 1 - j]
            // move top right to bottom right
            this[n - 1 - i][n - 1 - j] = this[j][n - 1 - i]
            // move top left to top right
            this[j][n - 1 - i] = temporaryTop
        }
    }
    return this
}
