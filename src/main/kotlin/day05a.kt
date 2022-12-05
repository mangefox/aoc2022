import java.util.*

fun main() {
    val lines = getInput("5").splitByEmptyLine()
    // array of 9 stacks
    val stacks = Array(9) { Stack<Char>() }

    for (line in lines) {
        var col = -1
        for ((i, l) in line.lines().withIndex()) {
            if ('[' in l) {
                for ((ii, ch ) in l.withIndex()) {
                    if (ch == '[') {
                        // 1 5 9 13 17 21 25 29 33
                        // 0 1 2 3  4  5  6  7  8
                        col = (ii/4)
                        println("pushing ${l[ii + 1]} to stack $col")
                        stacks[col].push(l[ii + 1])
                    }
                }
            } else {
                if (l.startsWith(" ")) {
                    println("#######")
                    for (stack in stacks) {
                        stack.reverse()
                        println(stack)
                    }
                    println("#######")
                    continue
                }
                if (l.isEmpty()) continue
                println("move = ${l}")
                val parts = l.split(" ")
                val amount = parts[1].toInt()
                val from = parts[3].toInt()
                val to = parts[5].toInt()

                // print from to amount
                println("move $amount from $from to $to")
                repeat(amount) {
                    for (stack in stacks) {
                        println(stack)
                    }
                    stacks[to-1].push(stacks[from-1].pop())
                }
                println("------------")
            }

            // moves

        }



//        for (line2  in line.lines()) {
//            val left = line.getOrNull(1)
//            val mid = line.getOrNull(5)
//            val right = line.getOrNull(9)
//            println("'$line'")
//            println("left = ${left}")
//            println("mid = ${mid}")
//            println("right = ${right}")
//        }

    }

    for (stack in stacks) {
        println(stack)
    }
    println(stacks.filter { it.isNotEmpty() }.map { it.pop() }.joinToString("") { it.toString() })
    println("lines.size = ${lines.size}")
}