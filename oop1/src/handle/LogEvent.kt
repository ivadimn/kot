package handle

import java.text.SimpleDateFormat
import java.util.Date

class LogEvent(
    val eventData:Any
) {
    private var date: String = getCurrentDate()

    // вам понадобится этот метод чтобы получить текущую дату и время
    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return dateFormat.format(Date())
    }

    override fun toString(): String {
        return "[$date]: $eventData"
    }
}