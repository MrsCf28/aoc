private val input = readResourceFileAsLines("2021-day3.txt")

fun main() {
    // What is the power consumption of the submarine?
    val binNumberLength = input[0].length
    val bitCounter: MutableList<Int> = List(binNumberLength) {0}.toMutableList()

    for (binaryNumber in input) {
        for (j in binaryNumber.indices) {
            if (binaryNumber[j].digitToInt() == 1) {
                bitCounter[j] += 1
            }
        }
    }

    val gammaRateList: MutableList<Int> = List(binNumberLength) {0}.toMutableList()
    val epsilonRateList: MutableList<Int> = List(binNumberLength) {0}.toMutableList()

    for (i in 0 until bitCounter.size) {
        if (bitCounter[i] > input.size / 2) {
            gammaRateList[i] = 1
        }
        else {
            epsilonRateList[i] = 1
        }
    }

    val gammaRate = Integer.parseInt(gammaRateList.joinToString(""), 2)
    val epsilonRate = Integer.parseInt(epsilonRateList.joinToString(""), 2)

    val powerConsumption = gammaRate * epsilonRate

    println(powerConsumption)
}