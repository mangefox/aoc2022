fun main() {
    val part2 = getInput("2")
        .lines()
        .map { line ->
            when (line) {
                "A X" -> 3 + 0 // rock  vs ? = lose -> sciss
                "A Y" -> 1 + 3 // rock  vs ? = draw -> rock
                "A Z" -> 2 + 6 // rock  vs ? = win  -> paper
                "B X" -> 1 + 0 // paper vs ? = lose -> rock
                "B Y" -> 2 + 3 // paper vs ? = draw -> paper
                "B Z" -> 3 + 6 // paper vs ? = win  -> sciss
                "C X" -> 2 + 0 // sciss vs ? = lose -> paper
                "C Y" -> 3 + 3 // sciss vs ? = draw -> sciss
                "C Z" -> 1 + 6 // sciss vs ? = win  -> rock
                else -> throw IllegalStateException("boom")
            }
        }
        .sum()

    require(part2 == 12411)
}