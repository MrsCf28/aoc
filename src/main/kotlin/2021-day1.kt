private val input = readResourceFileAsLines("2021-day1.txt").map { it.toInt() }

fun main() {
    // How many measurements are larger than the previous measurement?
    var counter1 = 0
    for (i in 1 until input.size) {
        if (input[i] > input[i - 1]) {
            counter1++
        }
    }
    var counter2 = 0
    for (i in 3 until input.size) {
        if (input[i] + input[i - 1] + input[i - 2] > input[i - 1] + input[i - 2] + input[i - 3]) {
            counter2++
        }
    }
    println("number of increases = $counter1")
    println("number of sliding increases = $counter2")
}