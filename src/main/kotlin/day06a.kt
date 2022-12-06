fun main() {
    val part1 = getInput("6")
        .windowed(4).indexOfFirst { it.toSet().size == 4 } + 4

    require(part1 == 1544)
}