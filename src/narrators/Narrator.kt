package narrators

import behaviors.Behavior

open class Narrator (val name: String): Behavior{
    override fun narrate(eventType: String): String {
        when(eventType){
            "welcome" -> return "\nWelcome to DOTA 2!\n"
            "gamebegins" -> return "\nLet the game begin!\n"
            "kill" -> return "\nA death has happened!\n"
            "towerDown" -> return "\nA tower has fallen!\n"
            "ancientDown" -> return "\nThe Ancient has fallen!\n"
            "radiantWins" -> return "\nRadiant has won!\n"
            "direWins" -> return "\nDeri has won!\n"
            "exit" -> return "\nSee you soon!\n"
        }
        return ""
    }
}