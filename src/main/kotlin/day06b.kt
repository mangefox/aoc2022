fun main() {
    val part2 = getInput("6")
        .windowed(14).withIndex()
        .first { (_, window) -> (window.toSet().size == 14) }
        .index + 14

    require(part2 == 2145)
}