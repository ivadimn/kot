package observer

import users.User

fun interface Observer<T> {
    fun onChanged(values: T)
}