class Dice {
    private var dieList = mutableListOf<Die>()

    init{
        for(i in 0..5){
            val die = Die()
            dieList.add(die)
        }
    }

    fun getDiceValues() : MutableList<Int>{
        val diceResult : MutableList<Int> = mutableListOf()
        for(die in dieList){
            diceResult += die.getNumber()
        }
        return diceResult
    }

    fun printDiceValues(){
        for(i in 0..5){
            println("Die #$i : " + dieList[i].getNumber() + "\n")
        }
    }

    fun rollDice(){
        for(die in dieList){
            if(!die.isLocked())
                die.roll()
        }
    }

    fun lockDice(){
        for(i in 0..5){
            while(true) {
                println("Lock die #$i? [Y/N]: ")
                val toLock = readLine()
                if (toLock == "Y") {
                    dieList[i].lock()
                    break
                } else if (toLock == "N") {
                    break
                } else {
                    println("Invalid input!")
                }
            }

        }
    }

    fun restoreDice(){
        for(die in dieList){
            die.restore()
        }
    }
}