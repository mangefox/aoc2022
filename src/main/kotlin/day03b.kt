fun main() {
    val points = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    val ans = getInput("3")
        .lines()
        .map(String::toSet)
        .chunked(size = 3)
        .flatMap { (a, b, c) -> a.intersect(b).intersect(c) }
        .sumOf { points.indexOf(it) + 1 }

    require(ans == 2641)
}