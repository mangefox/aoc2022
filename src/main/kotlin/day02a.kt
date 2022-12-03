fun main() {
    val part1 = getInput("2")
        .lines()
        .map { line ->
            when (line) {
                "A X" -> 1 + 3 // rock  vs rock  = draw
                "A Y" -> 2 + 6 // rock  vs paper = win
                "A Z" -> 3 + 0 // rock  vs sciss = lose
                "B X" -> 1 + 0 // paper vs rock  = lose
                "B Y" -> 2 + 3 // paper vs paper = draw
                "B Z" -> 3 + 6 // paper vs sciss = win
                "C X" -> 1 + 6 // sciss vs rock  = win
                "C Y" -> 2 + 0 // sciss vs paper = lose
                "C Z" -> 3 + 3 // sciss vs sciss = draw
                else -> throw IllegalStateException("boom")
            }
        }
        .sum()

    require(part1 == 14069)
}