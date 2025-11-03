package par610

import observer.MutableObservable
import kotlin.concurrent.thread
import kotlin.math.round
import kotlin.random.Random

// Репозиторий данных
object DataRepository {
    //var userData: String = "User_Initial"
    //var orderData: Int = 100
    //var priceData: Double = 99.99

    val userData = MutableObservable<String>("User_Initial")
    val orderData = MutableObservable<Int>(100)
    val priceData = MutableObservable<Double>(99.99)

    // Метод обновления данных
    fun updateData(newUser: String? = null, newOrder: Int? = null, newPrice: Double? = null) {
        newUser?.let { userData.currentValue = it }
        newOrder?.let { orderData.currentValue = it }
        newPrice?.let { priceData.currentValue = round(it * 100) / 100 }
    }
}

fun main() {
    // Запуск обновления данных
    //DataUpdater(DataRepository)

    // Подписка на обновления данных пользователя
    DataRepository.userData.registerObserver { newValue ->
        println("UserMonitor: Обнаружено изменение данных пользователя: $newValue")
    }

    // Подписка на обновления данных заказов
    DataRepository.orderData.registerObserver { newValue ->
        println("OrderMonitor: Обнаружено изменение данных заказа: $newValue")
    }

    // Подписка на обновления данных цены
    DataRepository.priceData.registerObserver { newValue ->
        println("PriceMonitor: Обнаружено изменение цены: $newValue")
    }

    DataRepository.updateData("New user", 250, 1500.50)
}

