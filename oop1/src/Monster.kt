import kotlin.random.Random

class Monster {
    val pawsCount : Int
    val eyesCount : Int
    val fangsCount : Int
    val clawsCount : Int
    val tentaclesCount : Int

    constructor() {
        this.pawsCount = Random.nextInt(1, 10)
        this.eyesCount = Random.nextInt(1, 10)
        this.fangsCount = Random.nextInt(1, 10)
        this.clawsCount = Random.nextInt(1, 10)
        this.tentaclesCount = Random.nextInt(1, 10)
    }

    constructor(default: Int):
            this(default, default, default, default, default)

    constructor(pawsCount : Int, eyesCount : Int, fangsCount : Int, clawsCount : Int, tentaclesCount : Int) {
        this.pawsCount = pawsCount
        this.eyesCount = eyesCount
        this.fangsCount = fangsCount
        this.clawsCount = clawsCount
        this.tentaclesCount = tentaclesCount
    }

    fun printInfo() {
       println("Кол-во лап: $pawsCount")
       println("Кол-во глаз: $eyesCount")
       println( "Кол-во клыков: $fangsCount")
       println( "Кол-во когтей: $clawsCount")
       println( "Кол-во щупалец: $tentaclesCount")
    }

}