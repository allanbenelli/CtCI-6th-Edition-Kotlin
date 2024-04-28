package Chapter01._08_zero_matrix

import Utility.IntMatrix
import Utility.print
import Utility.randomIntMatrix

fun main() {
    val matrix = randomIntMatrix(10, 10, -10, 10)
    matrix.print()
    println()
    matrix.setZeros()
    matrix.print()
}


fun IntMatrix.setZeros() {
    val m = this.size
    val n = this[0].size
    var rowHasZero = false
    var colHasZero = false
    
    for (j in 0 until n) {
        if (this[0][j] == 0) {
            rowHasZero = true
            break
        }
    }
    
    for (i in 0 until m) {
        if (this[i][0] == 0) {
            colHasZero = true
            break
        }
    }
    
    for (i in 1 until m) {
        for (j in 1 until n) {
            if (this[i][j] == 0) {
                this[0][j] = 0
                this[i][0] = 0
            }
        }
    }
    for (i in 1 until m) {
        if (this[i][0] == 0) {
            for (j in 1 until n) {
                this[i][j] = 0
            }
        }
    }
    
    for (j in 1 until n) {
        if (this[0][j] == 0) {
            for (i in 1 until m) {
                this[i][j] = 0
            }
        }
    }

    if (rowHasZero) {
        for (j in 0 until n) {
            this[0][j] = 0
        }
    }
    
    if (colHasZero) {
        for (i in 0 until m) {
            this[i][0] = 0
        }
    }
}