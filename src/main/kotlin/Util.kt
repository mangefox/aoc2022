import Util.fetchInput
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.file.Files.createDirectory
import java.nio.file.Files.createFile
import java.nio.file.Files.exists
import java.nio.file.Files.isDirectory
import java.nio.file.Files.readString
import java.nio.file.Path
import java.time.LocalDate
import kotlin.io.path.writeText

fun List<String>.toInts(): List<Int> = map { it.toInt() }
fun String.splitByEmptyLine(): List<String> = split(System.lineSeparator()+System.lineSeparator())
fun <T> List<List<T>>.transpose(): List<List<T>> {
    val result = (first().indices).map { mutableListOf<T>() }.toMutableList()
    forEach { list -> result.zip(list).forEach { it.first.add(it.second) } }
    return result
}

/*
Library functions todo
- split by empty line
- check interval overlap
- check interval contained
 */

object Util {
    private const val year = 2022
    private val cookie = readString(Path.of("cookie.txt"))

    internal fun fetchInput(day: String): String {
        val client = HttpClient.newBuilder().build()
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://adventofcode.com/$year/day/$day/input"))
            .header("Cookie", cookie)
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        val code = response.statusCode()
        if (code >= 300) {
            throw IllegalStateException("Response code was $code: \n${response.body()}")
        }
        return response.body()
    }
}

fun getInput(day: String): String {
    if (!isDirectory(Path.of("input"))) {
        createDirectory(Path.of("input"))
    }

    if (day.endsWith("t")) {
        val paddedDay = day.padStart(3, '0')
        return readString(Path.of("input/$paddedDay.txt"))
    } else {
        val paddedDay = day.padStart(2, '0')
        if (!exists(Path.of("input/$paddedDay.txt"))) {
            val input = fetchInput(day)
            val file = createFile(Path.of("input/$paddedDay.txt"))
            file.writeText(input)
        }

        return readString(Path.of("input/$paddedDay.txt"))
    }
}

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
                    for (line in lines) {
                        println("'${'$'}line'")
                    }
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