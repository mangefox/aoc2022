fun main() {
    val lines = getInput("2").lines()
    var count = 0
    for (line in lines) {
        val (op, me) = line.split(" ")
//
//        println("op = ${op}")
//        println("me = ${me}")

        // rock  1
        // paper 2
        // sciss 3
        when {
            op == "A" && me == "X" -> count += 3 + 0 // rock v  lose  scissors
            op == "A" && me == "Y" -> count += 1 + 3 // rock v  draw  rock
            op == "A" && me == "Z" -> count += 2 + 6 // rock v  win   paper
            op == "B" && me == "X" -> count += 1 + 0 // paper v lose  rock
            op == "B" && me == "Y" -> count += 2 + 3 // paper v draw  paper
            op == "B" && me == "Z" -> count += 3 + 6 // paper v  lose ciss
            op == "C" && me == "X" -> count += 2 + 0 // scissors v win  rock
            op == "C" && me == "Y" -> count += 3 + 3 // scissors v draw sciss
            op == "C" && me == "Z" -> count += 1 + 6 // scissors v lose rock
        }
    }
    println("count = ${count}")
}