fun main() {
    val part1 = getInput("6")
        .windowed(4).withIndex()
        .first { (_, window) -> (window.toSet().size == 4) }
        .index + 4

    require(part1 == 1544)
}