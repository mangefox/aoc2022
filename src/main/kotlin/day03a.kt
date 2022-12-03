fun main() {
    val points = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    val ans = getInput("3")
        .lines()
        .flatMap { line ->
            val left = line.take(line.length / 2).toSet()
            val right = line.drop(line.length / 2).toSet()
            left.intersect(right)
        }
        .sumOf { points.indexOf(it) + 1 }

    require(ans == 8401)
}