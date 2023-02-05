package mockk

class NormalClass {
    fun setName(name : String) : Unit { }

    fun getName() : String = "A"

    fun getScore() : Int = 123

    fun printInfo() : Unit = println("name: ${getName()}, score: ${getScore()}")

    fun start() {
        doSomething()
    }

    fun doSomething() { }
}