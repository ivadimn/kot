package collections

interface MyMutableList<T> : MyList<T>, MyMutableCollection<T> {

    override val size : Int

    override fun add(element : T) : Boolean
    operator fun plus(element : T)
    fun add(index : Int, element : T) : Boolean
    override operator fun get(index : Int) : T
    fun removeAt(index : Int)
    operator fun minus(element: T)
    override fun remove(element : T)
    override fun clear()
    override fun contains(element : T) : Boolean
}