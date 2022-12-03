private fun main() {
    val calories = day1Input().split("\n\n")
        .map { individualCalories ->
            individualCalories.split("\n")
                .map { individualCalories -> individualCalories.toInt() }
        }.map { caloriesPerElf -> caloriesPerElf.sum() }
        .sortedDescending()
        .take(3)
        .sum()
    println(calories)
}