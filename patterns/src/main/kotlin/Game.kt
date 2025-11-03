import kotlin.concurrent.thread
import kotlin.random.Random

fun main() {
    print("Введите число от 0 до 1_000_000_000: ")
    val number = readln().toInt();
    var isWin = false
    thread {
        var seconds = 1;
        while (!isWin) {
            println(seconds++);
            Thread.sleep(1000)
        }
    }

    thread {
        var randomNumber: Int
        var upperBoard = 1_000_000_000
        var lowerBoard = 0

        while (!isWin) {
            randomNumber = Random.nextInt(lowerBoard, upperBoard)
            if (number == randomNumber) {
                println("Я выиграл, твоё число: $randomNumber")
                isWin = true
            }
            val middle = upperBoard - lowerBoard
            if (randomNumber < middle)
                upperBoard = middle;
            else
                lowerBoard = middle
        }
    }
}