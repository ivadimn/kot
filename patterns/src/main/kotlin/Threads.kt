import kotlin.concurrent.thread

class ThreadRunner {
    fun runThreads(): Map<String, String> {
        val threadInfo = mutableMapOf<String, String>()

        // Добавьте в Map имя главного потока и описание его работы
        threadInfo[Thread.currentThread().name] = "Главный поток, который управляет выполнением"

        // Запустите три потока, добавляя в Map имя потока и описание его работы
        val thread1 = thread {
            var summa = 0;
            for (i in (0 .. 1_000_000))
                summa++
        }

        val thread2 = thread {
            var summa = 0;
            for (i in (0 .. 1_000_000))
                summa++
        }

        val thread3 = thread {
            var summa = 0;
            for (i in (0 .. 1_000_000))
                summa++
        }

        // Дождитесь завершения потоков, чтобы они успели записать свои имена в Map
        thread1.join()
        thread2.join()
        thread3.join()
        threadInfo[thread1.name] = "Выполняет вычисления 1"
        threadInfo[thread2.name] = "Выполняет вычисления 2"
        threadInfo[thread3.name] = "Выполняет вычисления 3"
         return threadInfo
    }
}

fun main() {
    val info = ThreadRunner().runThreads()
    println(info)
}