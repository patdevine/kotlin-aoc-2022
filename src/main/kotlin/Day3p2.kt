fun main() {


    fun day3SampleInput(): String = """vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw""".trimIndent()

    fun getPriorityValue(it: Char): Int {
        return if (it.code > 96) {
            it.code - 96 // lowercase a = 97
        } else {
            it.code - 65 + 27
        }
    }

    fun findInterections(grouping: MutableList<String>): Int {
        val ruck1 = grouping.first().toSet()
        val ruck2 = grouping[1].toSet()
        val ruck3 = grouping[2].toSet()

        val ruck1and2 = ruck1.intersect(ruck2)
        print(ruck1and2)
        for (char in ruck3) {
            if (ruck1and2.contains(char)) {
                return getPriorityValue(char)
            }
        }
        return 0
    }

    fun part2(input: List<String>) : Int {
        var sum = 0
        val grouping = mutableListOf<String>()
        input.forEach { rucksack ->
            grouping.add(rucksack)
            if (grouping.size == 3) {
                sum += findInterections(grouping)
                grouping.clear()
            }
        }
        return sum
    }

    println(part2(day3SampleInput().split("\n")))
    println(part2(day3Input().split("\n")))
}