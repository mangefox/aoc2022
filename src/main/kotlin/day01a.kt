fun main() {
    val part1 = getInput("1").splitByEmptyLine()
        .map { group -> group.lines().sumOf { it.toInt() } }
        .max()

    require(part1 == 68802)
}