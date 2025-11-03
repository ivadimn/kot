package users

import kotlinx.serialization.json.Json
import observer.MutableObservable
import observer.Observable
import observer.Observer
import java.io.File

class UserRepository private constructor() {

    init {
        println("User repository created");
    }
    private val db = File("users.json")
    private val _usersList = load()

    private fun load() : MutableList<User> = Json.Default.decodeFromString<MutableList<User>>(db.readText().trim())

    private val _users = MutableObservable<List<User>>(_usersList.toList())
    val users: Observable<List<User>>
        get() = _users

    private val _oldestUser = MutableObservable<User>(_usersList.maxBy { it.age })
    val oldestUser: Observable<User>
        get() = _oldestUser

    fun add(firstName : String, lastName: String, age: Int) {
        val id = _usersList.maxOf { it.id } + 1
        _usersList.add(User(id, firstName, lastName, age));
        _users.currentValue = _usersList.toList()
        _oldestUser.currentValue = _usersList.maxBy { it.age }
    }

    fun delete(id: Int) {
        _usersList.removeIf { it.id == id }
        _users.currentValue = _usersList.toList()
        _oldestUser.currentValue = _usersList.maxBy { it.age }
    }

    fun save() {
        val content = Json.encodeToString(_usersList)
        db.writeText(content);
    }


    companion object {
        private val lock = Any()
        private var instance : UserRepository? = null
        fun getInstance(password: String) : UserRepository {
            val correct = File("password.txt").readText().trim()
            if (correct != password) throw IllegalArgumentException("Неправильный пароль!")
            instance?.let { return it }
            synchronized(lock) {
                instance?.let { return it }

                return UserRepository().also {
                    instance = it
                }
            }
        }
    }


}