fun main() {
    val lines = getInput("2").lines()
    var count = 0
    for (line in lines.withIndex()) {
        val round = line.index + 1
        val (op, me) = line.value.split(" ")

        println("round = ${round}")
        println("op = ${op}")
        println("me = ${me}")
        when {
            op == "A" && me == "X" -> count += 1 + 3 // rock v rock
            op == "A" && me == "Y" -> count += 2 + 6 // rock v paper
            op == "A" && me == "Z" -> count += 3 + 0 // rock v scissors
            op == "B" && me == "X" -> count += 1 + 0 // paper v rock
            op == "B" && me == "Y" -> count += 2 + 3 // paper v paper
            op == "B" && me == "Z" -> count += 3 + 6 // paper v scissors
            op == "C" && me == "X" -> count += 1 + 6 // scissors v rock
            op == "C" && me == "Y" -> count += 2 + 0 // scissors v paper
            op == "C" && me == "Z" -> count += 3 + 3 // scissors v scissors
        }
    }
    println("count = ${count}")
}