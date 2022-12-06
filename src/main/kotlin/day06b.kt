fun main() {
    var part2 = 0
    for (line in getInput("6").lines()) {
        for ((i, window) in line.windowed(14).withIndex()) {
            if (window.toSet().size == 14) {
                part2 += i+14
                break
            }
        }
    }

    require(part2 == 2145)
}