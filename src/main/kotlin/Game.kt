import java.util.Collections

class Game(private var dice: Dice) {

    fun play(){
        dice.restoreDice()
        dice.rollDice()
        dice.printDiceValues()
        println(checkResult(dice.getDiceValues()))
        dice.lockDice()
        dice.rollDice()
        dice.printDiceValues()
        println(checkResult(dice.getDiceValues()))
    }

    private fun checkResult(results: MutableList<Int>): String{
        //https://www.techiedelight.com/count-occurrences-each-element-list-kotlin/

        for(result in results.distinct()){
            if(Collections.frequency(results, result) >= 5){
                return "Yahtzee"
            }
            if(Collections.frequency(results, result) == 4){
                return "Poker"
            }
        }

        if(results.distinct().size >=5 && results.distinct().containsAll(listOf(1,2,3,4,5))){
            return "SmallStraight"
        }

        if(results.distinct().size >=5 && results.distinct().containsAll(listOf(2,3,4,5,6))){
            return "BigStraight"
        }

        return "No matches"
    }

}