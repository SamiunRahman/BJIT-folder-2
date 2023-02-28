interface Transport {
    fun move()
}

interface Engine {
    fun startEngine()
}

class CNGAutoRickshaw : Transport {
    private val engine: Engine

    constructor(engine: Engine) {
        this.engine = engine
    }

    override fun move() {
        engine.startEngine()
        println("Driving a CNG Auto Rickshaw.")
    }
}

class MotorCycle : Transport {
    private val engine: Engine

    constructor(engine: Engine) {
        this.engine = engine
    }

    override fun move() {
        engine.startEngine()
        println("Driving a Motorcycle.")
    }
}

class CNGEngine : Engine {
    override fun startEngine() {
        println("Starting CNG engine.")
    }
}

class PetrolEngine : Engine {
    override fun startEngine() {
        println("Starting Petrol engine.")
    }
}
fun main(){
    val cngAutoRickshaw = CNGAutoRickshaw(CNGEngine())
    val motorcycle = MotorCycle(PetrolEngine())

    cngAutoRickshaw.move()
    motorcycle.move()
}

