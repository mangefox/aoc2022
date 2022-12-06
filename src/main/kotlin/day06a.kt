fun main() {
    var part1 = 0
    for (line in getInput("6").lines()) {
        for ((i, window) in line.windowed(4).withIndex()) {
            if (window.toSet().size == 4) {
                part1 += i+4
                break
            }
        }
    }

    require(part1 == 1544)
}