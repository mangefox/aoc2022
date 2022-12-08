fun main() {
    fun visible(grid: List<String>, x: Int, y: Int): Int {
        val height = grid[y][x]
        val ymax = grid.lastIndex
        val xmax = grid[0].lastIndex

        val l = (0 until x).all { grid[y][it] < height }
        val r = (x+1..xmax).all { grid[y][it] < height }
        val t = (0 until y).all { grid[it][x] < height }
        val b = (y+1..ymax).all { grid[it][x] < height }
        return if (l || r || t || b) 1 else 0
    }

    val lines = getInput("8").lines()
    var part1 = lines.lastIndex * 4 // perimeter
    for (y in 1 until lines.lastIndex) {
        for (x in 1 until lines[y].lastIndex) {
            part1 += visible(lines, x, y)
        }
    }

    require(part1 == 1736)
}