package handle

import handle.Transformable

class Encryptor : DataProcessor("Encryptor"), Transformable {
    override fun transform(data: String): String {
        return "$processorName преобразовал данные: encoded_$data"
    }
}