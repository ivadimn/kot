package dogs

import kotlinx.serialization.json.Json
import observer.MutableObservable
import observer.Observable
import observer.Observer
import java.io.File

class DogsRepository private constructor()  {

    init {
        println("Dogs repository created!")
    }
    private val db = File("dogs.json")
    private val _dogsList = loadDogs()

    private val _dogs = MutableObservable<List<Dog>>(_dogsList)
    val dogs : Observable<List<Dog>>
        get() = _dogs

    private fun loadDogs() : MutableList<Dog> = Json.Default.decodeFromString<MutableList<Dog>>(db.readText().trim())

    fun add(dogName: String, breedName: String, weight: Int) {
        val id = _dogsList.maxOf { it.id } + 1
        _dogsList.add(Dog(id, dogName, breedName, weight))
        _dogs.currentValue = _dogsList.toList()
    }

    fun delete(id: Int) {
        _dogsList.removeIf { it.id == id }
        _dogs.currentValue = _dogsList.toList()
    }

    fun save() {
        val content = Json.encodeToString(_dogsList)
        db.writeText(content)
    }

    companion object {
        private val lock = Any()
        private var instance : DogsRepository? = null
        fun getInstance(password: String) : DogsRepository {
            val correct = File("password.txt").readText().trim()
            if (correct != password) throw IllegalArgumentException("Неправильный пароль!")
            instance?.let { return it }
            synchronized(lock) {
                instance?.let { return it }

                return DogsRepository().also {
                    instance = it
                }
            }
        }
    }

}