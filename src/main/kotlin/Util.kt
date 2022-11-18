import Util.fetchInput
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.file.Files
import java.nio.file.Files.createDirectory
import java.nio.file.Files.createFile
import java.nio.file.Files.exists
import java.nio.file.Files.isDirectory
import java.nio.file.Files.readAllLines
import java.nio.file.Path
import kotlin.io.path.writeBytes

object Util {
    private const val year = 2022
    private val cookie = Files.readString(Path.of("cookie.txt"))

    internal fun fetchInput(day: Int): String {
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

fun getInput(day: Int): List<String> {
    if (!isDirectory(Path.of("input"))) {
        createDirectory(Path.of("input"))
    }

    if (!exists(Path.of("input/$day.txt"))) {
        val input = fetchInput(day)
        val file = createFile(Path.of("input/$day.txt"))
        file.writeBytes(input.toByteArray())
    }

    return readAllLines(Path.of("input/$day.txt"))
}
