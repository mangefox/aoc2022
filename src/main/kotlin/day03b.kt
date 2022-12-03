fun main() {
    val points = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    val part2 = getInput("3")
        .lines()
        .map(String::toSet)
        .chunked(size = 3)
        .flatMap { (a, b, c) -> a.intersect(b).intersect(c) }
        .sumOf { points.indexOf(it) + 1 }

    require(part2 == 2641)
}