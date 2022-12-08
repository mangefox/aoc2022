fun main() {


    fun visible(grid: List<String>, x: Int, y: Int): Int {
        val height = grid[y][x].digitToInt()
        println("inspecting = ${grid[y][x]}")
        var treesVisible = 0
        // from left

        var visibleFromLeft = 0
        for (i in x-1 downTo 0) {
            if (grid[y][i].digitToInt() < height) {
                println("x=$x, y=$y, i=$i, height=$height is visible from left (${grid[y][i]})")
                visibleFromLeft += 1
            } else {
                println("x=$x, y=$y, i=$i, height=$height is last tree visible from left (${grid[y][i]})")
                visibleFromLeft += 1
                break
            }
        }

        // from right
        var visibleFromRight = 0
        for (i in x+1 until grid[y].length) {
            if (grid[y][i].digitToInt() < height) {
                println("x=$x, y=$y, i=$i, height=$height is visible from right (${grid[y][i]})")
                visibleFromRight += 1
            } else {
                println("x=$x, y=$y, i=$i, height=$height is last tree visible from right (${grid[y][i]})")
                visibleFromRight += 1
                break
            }
        }
        // from top
        var visibleFromTop = 0
        for (i in y-1 downTo 0) {
            if (grid[i][x].digitToInt() < height) {
                println("x=$x, y=$y, i=$i, height=$height is visible from top (${grid[i][x]})")
                visibleFromTop += 1
            } else {
                println("x=$x, y=$y, i=$i, height=$height is last tree visible from top (${grid[i][x]})")
                visibleFromTop += 1
                break
            }
        }
        // from bottom
        var visibleFromBottom = 0
        for (i in y+1 until grid.size) {
            if (grid[i][x].digitToInt() < height) {
                println("x=$x, y=$y, i=$i, height=$height is visible from bottom (${grid[i][x]})")
                visibleFromBottom += 1
            } else {
                println("x=$x, y=$y, i=$i, height=$height is last tree visible from bottom (${grid[i][x]})")
                visibleFromBottom += 1
                break
            }
        }
        println("score = ${visibleFromTop * visibleFromBottom * visibleFromLeft * visibleFromRight}")
        return visibleFromTop * visibleFromBottom * visibleFromLeft * visibleFromRight
//        return treesVisible
//        return sidesVisibleFrom
    }

    var count = 0
    val lines = getInput("8t").lines()
    for (y in 1 until lines.lastIndex) {
        for (x in 1 until lines[y].lastIndex) {
            count = Math.max(count, visible(lines, x, y))
        }
    }
//    count += (lines[0].length-1) * 2
//    count += (lines.size-1) * 2
    println("count = ${count}") // 268800
}