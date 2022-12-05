import java.util.*

fun main() {
    val stacks = Array(9) { LinkedList<Char>() }
    val (state, moves) = getInput("5").split("\n\n")

    for (line in state.lines()) {
        for ((col, chunk) in line.chunked(4).withIndex()) {
            if (chunk.isNotBlank()) {
                stacks[col].add(chunk[1])
            }
        }
    }

    for (move in moves.trim().lines()) {
        val (amount, from, to) = move
            .filter { !it.isLetter() }
            .trim()
            .split("\\s+".toRegex())
            .map { it.toInt() }

        val tmpstack = Stack<Char>()
        repeat(amount) {
            tmpstack.push(stacks[from-1].pop())
        }
        repeat(amount) {
            stacks[to-1].push(tmpstack.pop())
        }
    }

    val part2 = stacks
        .filter { it.isNotEmpty() }
        .map { it.pop() }
        .joinToString("")

    require(part2 == "RGLVRCQSB")
}