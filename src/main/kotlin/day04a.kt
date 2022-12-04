fun main() {
    val part1 = getInput("4").lines()
        .count { line ->
            val (left, right) = line.split(",")
            val (lstart, lend) = left.split("-").map(String::toInt)
            val (rstart, rend) = right.split("-").map(String::toInt)
            lstart <= rstart && lend >= rend || rstart <= lstart && rend >= lend
        }

    require(part1 == 582)
}