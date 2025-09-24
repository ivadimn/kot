package handle

open class DataProcessor(
    val processorName: String
) {
    fun process(data: String): String {
        return "Обработчик: $processorName обработал данные"
    }
}