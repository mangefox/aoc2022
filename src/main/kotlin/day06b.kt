fun main() {
    val part2 = getInput("6")
        .windowed(14).indexOfFirst { it.toSet().size == 14 } + 14

    require(part2 == 2145)
}