fun main() {
    fun visible(grid: List<String>, x: Int, y: Int): Int {
        val height = grid[y][x].digitToInt()

        // from left
        var visibleFromLeft = true
        for (i in 0 until x) {
            if (grid[y][i].digitToInt() >= height) {
                println("x=$x, y=$y, i=$i, height=$height is visible from left (${grid[y][i]})")
                visibleFromLeft = false
                break
            }
        }

        // from right
        var visibleFromRight = true
        for (i in x+1 until grid[y].length) {
            if (grid[y][i].digitToInt() >= height) {
                println("x=$x, y=$y, i=$i, height=$height is visible from right (${grid[y][i]})")
                visibleFromRight = false
                break
            }
        }
        // from top
        var visibleFromTop = true
        for (i in 0 until y) {
            if (grid[i][x].digitToInt() >= height) {
                println("x=$x, y=$y, i=$i, height=$height is visible from top (${grid[i][x]})")
                visibleFromTop = false
                break
            }
        }
        // from bottom
        var visibleFromBottom = true
        for (i in y+1 until grid.size) {
            if (grid[i][x].digitToInt() >= height) {
                println("x=$x, y=$y, i=$i, height=$height is visible from bottom (${grid[i][x]})")
                visibleFromBottom = false
                break
            }
        }


        if (listOf(visibleFromLeft, visibleFromRight, visibleFromTop, visibleFromBottom).count { it } > 0)
//        if (sidesVisibleFrom > 0)
            return 1
        else
            return 0
//        return sidesVisibleFrom
    }

    var count = 0
    val lines = getInput("8").lines()
    for (y in 1 until lines.lastIndex) {
        for (x in 1 until lines[y].lastIndex) {
            count += visible(lines, x, y)
        }
    }
    count += (lines[0].length-1) * 2
    count += (lines.size-1) * 2
    println("count = ${count}")
    // 1736
}