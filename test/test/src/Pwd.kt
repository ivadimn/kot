fun main() {
    val pwd = readln().toCharArray()
    var hasHard = false
    for (symbol in pwd)
    {
        if (symbol.equals('Ъ')) {
            hasHard = true
            break
        }
    }
    if (hasHard)
        println("У вас идеальный пароль!")
    else
        println("Опс! В вашем пароле кое-чего не хватает.")
}