package narrators

import behaviors.Behavior

class SpanisNarrator(name: String): Narrator(name), Behavior{
    override fun narrate(eventType: String): String {
        when(eventType){
            "welcome" -> return "\nBienvenidos a DOTA 2!\n"
            "gamebegins" -> return "\nQue comience el juego!\n"
            "kill" -> return "\nHa ocurrido una muerte!\n"
            "towerDown" -> return "\nUna torre ha caido!\n"
            "ancientDown" -> return "\nThe Ancient has fallen!\n"
            "radiantWins" -> return "\nRadiant ha ganado!\n"
            "direWins" -> return "\nDeri ha ganado!\n"
            "exit" -> return "\nHasta la proxima amigo!\n"
        }
        return ""
    }
}