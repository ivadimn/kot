package files

import java.io.File

fun main() {
    val file = File("tasks.txt")
    val operationCode = OperationCode.entries
    while (true) {
        print("Введите код операции")
        for ((i, code) in operationCode.withIndex()) {
            print(", $i - ${code.title}")
        }
        print(": ")
        val index: Int = readln().toInt()
        when(operationCode[index]) {
            OperationCode.EXIT -> break
            OperationCode.ADD_NEW_TASK -> {
                print("Введите наименование задачи: ")
                val task = readln()
                file.appendText("$task\n")
            }
            OperationCode.SHOW_TASKS -> {
                val lines = file.readLines()
                for ((index, line) in lines.withIndex())
                    println("${index + 1}. $line")
            }
        }
    }
}