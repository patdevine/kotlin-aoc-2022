fun main () {

    fun part2(input: List<String>): Int {
        val col1Map = mapOf("A" to Hand.ROCK, "B" to Hand.PAPER, "C" to Hand.SCISSORS)
        val col2Map = mapOf("X" to Hand.ROCK, "Y" to  Hand.PAPER, "Z" to Hand.SCISSORS)

        val inverseCol2Map = mapOf(Hand.ROCK to "X", Hand.PAPER to "Y", Hand.SCISSORS to "Z")
        val winningMap = mapOf(Hand.SCISSORS to Hand.ROCK, Hand.ROCK to Hand.PAPER, Hand.PAPER to Hand.SCISSORS)

        val inverseWinningMap = mapOf(Hand.ROCK to Hand.SCISSORS, Hand.PAPER to Hand.ROCK, Hand.SCISSORS to Hand.PAPER)
        val pointsMap = mapOf("win" to 6, "lose" to 0, "draw" to 3, "X" to 1, "Y" to 2, "Z" to 3)

        val resultMap = mapOf("X" to "lose", "Y" to "draw", "Z" to "win")

        var totalScore = 0

        for (i in input) {
            val handOne = i[0].toString()
            val handTwo = i[2].toString()
            var realHandTwo = ""

            if (resultMap[handTwo] == "win") {
                realHandTwo = inverseCol2Map[winningMap[col1Map[handOne]!!]!!]!!
            } else if (resultMap[handTwo] == "draw") {
                realHandTwo = inverseCol2Map[col1Map[handOne]!!]!!
            } else {
                realHandTwo = inverseCol2Map[inverseWinningMap[col1Map[handOne]!!]!!]!!
            }

            if (col1Map[handOne] == col2Map[realHandTwo]) {
                totalScore += pointsMap["draw"]!! + pointsMap[realHandTwo]!!
            } else if (winningMap[col1Map[handOne]!!] == col2Map[realHandTwo]) {
                totalScore += pointsMap["win"]!! + pointsMap[realHandTwo]!!
            } else {
                totalScore += pointsMap[realHandTwo]!!
            }
        }

        return totalScore
    }
    println(part2(day2Input().split("\n")))
}

enum class Hand {
    ROCK,PAPER,SCISSORS
}