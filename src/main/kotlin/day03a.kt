fun main() {
    val points = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    val part1 = getInput("3")
        .lines()
        .flatMap { line ->
            val left = line.take(line.length / 2).toSet()
            val right = line.drop(line.length / 2).toSet()
            left.intersect(right)
        }
        .sumOf { points.indexOf(it) + 1 }

    require(part1 == 8401)
}