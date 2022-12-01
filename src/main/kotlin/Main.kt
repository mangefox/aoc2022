import java.nio.file.Files.createDirectory
import java.nio.file.Files.createFile
import java.nio.file.Files.exists
import java.nio.file.Files.isDirectory
import java.nio.file.Path
import java.time.LocalDate
import kotlin.io.path.writeText

/**
 * Create files in preparation for the current day's puzzle.
 */
fun main() {
    val day = LocalDate.now().dayOfMonth
    val month = LocalDate.now().monthValue

    if (month == 12 && day <= 25) {
        val dayStr = day.toString().padStart(2, '0')
        val partA = "src/main/kotlin/day${dayStr}a.kt"
        val partB = "src/main/kotlin/day${dayStr}b.kt"
        val input = "input/${dayStr}.txt"
        val testInput = "input/${dayStr}t.txt"

        val content = """
                fun main() {
                    val lines = getInput("$day").lines()
                    lines.forEach { println("'${'$'}it'") }
                    println("lines.size = ${'$'}{lines.size}")
                }
            """.trimIndent()

        for (part in listOf(partA, partB)) {
            if (!exists(Path.of(part))) {
                val file = createFile(Path.of(part))
                file.writeText(content)
                println("created '$part'")
            }
        }
        if (!isDirectory(Path.of("input"))) {
            createDirectory(Path.of("input"))
        }
        if (!exists(Path.of(testInput))) {
            createFile(Path.of(testInput))
            println("created '$testInput'")
        }
        if (!exists(Path.of(input))) {
            getInput(day.toString())
            println("created '$input'")
        }
    }
}