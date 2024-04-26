package Utility

import kotlin.random.Random

typealias IntMatrix = Array<IntArray>

private val random = Random.Default

fun randomInt(n: Int): Int = random.nextInt(n)

fun randomIntInRange(min: Int, max: Int): Int = random.nextInt(min, max + 1)

fun randomIntMatrix(m: Int, n: Int, min: Int, max: Int) : IntMatrix = Array(m) { IntArray(n) { randomIntInRange(min, max) } }

fun IntMatrix.print() {
    this.forEach { row ->
        row.forEach { value ->
            print(value.toString().padStart(4, ' '))
        }
        println()
    }
}

fun IntMatrix.isSquare(): Boolean = this.size == this[0].size

fun IntMatrix.returnCopyOf() : IntMatrix = this.map { row -> row.copyOf() }.toTypedArray()

