fun main() {
    val part2 = getInput("4").lines()
        .count { line ->
            val (left, right) = line.split(",")
            val (lstart, lend) = left.split("-").map(String::toInt)
            val (rstart, rend) = right.split("-").map(String::toInt)
            !(rstart > lend || lstart > rend)
        }

    require(part2 == 893)
}