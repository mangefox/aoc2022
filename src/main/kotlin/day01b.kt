fun main() {
    val part2 = getInput("1").splitByEmptyLine()
        .map { group -> group.lines().sumOf { it.toInt() } }
        .sorted()
        .takeLast(3)
        .sum()

    require(part2 == 205370)
}