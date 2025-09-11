fun main() {
    print("Введите количество секунд: ")
    val totalSeconds = readln().toInt()
    val hours = totalSeconds / 3600
    val otherSeconds = totalSeconds % 3600
    val minutes = otherSeconds / 60
    val seconds = otherSeconds % 60
    println("Результат в виде таймера: $hours : $minutes : $seconds")
}