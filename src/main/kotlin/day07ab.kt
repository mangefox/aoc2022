fun main() {
    val dirs = mutableMapOf<String, Int>()
    val pwd = mutableListOf<String>()

    for (line in getInput("7").lines()) {
        when {
            line == "$ cd .." -> pwd.removeLast()
            line.startsWith("$ cd ") -> pwd.add(line.drop(5))
            line.first().isDigit() -> {
                val size = line.takeWhile { it.isDigit() }.toInt()
                for (dir in pwd.runningReduce { acc, d -> "$acc/$d" }) {
                    dirs.merge(dir, size, Int::plus)
                }
            }
        }
    }
    val part1 = dirs.values.filter { it <= 100_000 }.sum()
    val part2 = dirs.values.filter { it >= dirs["/"]!! - 40_000_000 }.min()

    require(part1 == 1391690)
    require(part2 == 5469168)
}