private val input = readResourceFileAsLines("2021-day2.txt")

fun main() {
    // What do you get if you multiply your final horizontal position by your final depth?

    var horizontalPosition = 0
    var finalDepth = 0
    var aim = 0

    for (i in input) {
        val (direction, length) = i.split(" ")
        when (direction) {
            "forward" -> {
                horizontalPosition += length.toInt()
                finalDepth += aim * length.toInt()
            }
            "down" -> aim += length.toInt()
            "up" -> aim -= length.toInt()
            else -> println("unknown command")
        }
    }

    println(horizontalPosition * finalDepth)
}