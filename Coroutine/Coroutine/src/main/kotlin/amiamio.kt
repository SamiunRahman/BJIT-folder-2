import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class amiamio {



    val formatter = DateTimeFormatter.ISO_LOCAL_TIME
    val time = { formatter.format(LocalDateTime.now()) }

    suspend fun getValue(): Double {
        println("entering getValue() at ${time()}")
        delay(3000)
        println("leaving getValue() at ${time()}")
        return Math.random()
    }

    fun main() {
        runBlocking {
            val num1 = getValue()
            val num2 = getValue()
            println("result of num1 + num2 is ${num1 + num2}")
        }
    }
}