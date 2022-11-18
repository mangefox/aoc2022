import java.nio.file.Files.createFile
import java.nio.file.Files.exists
import java.nio.file.Path
import java.time.LocalDate
import kotlin.io.path.writeBytes

fun main() {
    val day = LocalDate.now().dayOfMonth
    val month = LocalDate.now().monthValue

    if (month == 12 && day <= 25) {
        val dayStr = day.toString().padStart(2, '0')
        val partA = "src/main/kotlin/day${dayStr}a.kt"
        val partB = "src/main/kotlin/day${dayStr}b.kt"

        val content = """
                fun main() {
                    val lines = getInput($day)
                    lines.forEach { println(it) }
                    println("lines.size = ${'$'}{lines.size}")
                }
            """.trimIndent()

        for (part in listOf(partA, partB)) {
            if (!exists(Path.of(part))) {
                val file = createFile(Path.of(part))
                file.writeBytes(content.toByteArray())
                println("created '$part'")
            }
        }
    }
}