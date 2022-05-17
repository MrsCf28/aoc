private val input = readResourceFileAsLines("2021-day3.txt")

fun main() {

    println("Oxygen Generator Rating = " + calculateOxygenGeneratorRating(input))
    println("CO2 Scrubber Rating = " + calculateCO2ScrubberRating(input))
    println("Life Support Rating = " + calculateLifeSupportRating(input))

}

private fun countDigitsAtPosition(binaryList: List<String>, position: Int): Pair<Int, Int>  {
    var numberOfZeros = 0
    var numberOfOnes = 0

    for (binaryNumber in binaryList) {
        if (binaryNumber[position] == '1') {
            numberOfOnes++
        } else {
            numberOfZeros++
        }
    }

    return numberOfZeros to numberOfOnes
}

private fun mostCommonDigitAtPosition(binaryList: List<String>, position: Int): Int {

    val (numberOfZeros, numberOfOnes) = countDigitsAtPosition(binaryList, position)
    return if (numberOfZeros > numberOfOnes) {
        0
    } else {
        1
    }
}

private fun leastCommonDigitAtPosition(binaryList: List<String>, position: Int): Int {

    val (numberOfZeros, numberOfOnes) = countDigitsAtPosition(binaryList, position)
    return if (numberOfZeros > numberOfOnes){
        1
    } else {
        0
    }
}

private fun calculateOxygenGeneratorRating(binaryList: List<String>): Int {
    var whittlingList = binaryList.toMutableList()
    var position = 0

    while (whittlingList.size != 1) {
        val mostCommonDigit = mostCommonDigitAtPosition(whittlingList, position)
        val tempList = mutableListOf<String>()
        for (binaryNumber in whittlingList) {
            if (binaryNumber[position].digitToInt() == mostCommonDigit) {
                tempList.add(binaryNumber)
            }
        }
        whittlingList = tempList
        position++
    }
    println("Whittling List = ${whittlingList[0]}")

    return Integer.parseInt(whittlingList[0], 2)

}

private fun calculateCO2ScrubberRating(binaryList: List<String>): Int {
    var whittlingList = binaryList.toMutableList()
    var position = 0

    while (whittlingList.size != 1) {
        val leastCommonDigit = leastCommonDigitAtPosition(whittlingList, position)
        val tempList = mutableListOf<String>()
        for (binaryNumber in whittlingList) {
            if (binaryNumber[position].digitToInt() == leastCommonDigit) {
                tempList.add(binaryNumber)
            }
        }
        whittlingList = tempList
        position++
    }
    println("Whittling List = ${whittlingList[0]}")

    return Integer.parseInt(whittlingList[0], 2)

}

private fun calculateLifeSupportRating(binaryList: List<String>): Int =
    calculateOxygenGeneratorRating(binaryList) * calculateCO2ScrubberRating(binaryList)