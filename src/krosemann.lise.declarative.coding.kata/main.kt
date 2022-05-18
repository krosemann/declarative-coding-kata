package krosemann.lise.declarative.coding.kata

fun main() {
    val input = "lise"
    val result = sumOfDigitsOfStringAfterConvert(input, 3)
    println(result)
}

fun sumOfDigitsOfStringAfterConvert(input: String, times: Int) =
    input
        .asPositionsInAlphabet()
        .repeat({ it.checksum() }, times)

fun String.asPositionsInAlphabet() =
    this.lowercase().map { positionInAlphabet(it) }.joinToString("")

const val asciiLowercaseOffset = 96
fun positionInAlphabet(char: Char) = char.code - asciiLowercaseOffset

fun String.checksum() = this.map { it.digitToInt() }.sum().toString()

tailrec fun <T> T.repeat(transform: (T) -> T, times: Int): T =
    if (times == 0) this
    else transform(this).repeat(transform, times - 1)
