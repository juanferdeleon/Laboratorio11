package narrators

import behaviors.Behavior

class EnglishNarrator(name: String): Narrator(name), Behavior {
    override fun narrate(eventType: String): String {
        when(eventType){
            "welcome" -> return "Welcome to DOTA 2!"
            "gamebegins" -> return "Let the game begin!"
            "kill" -> return "A death has happened!"
            "towerDown" -> return "A tower has fallen!"
            "radiantWins" -> return "Radiant has won!"
            "direWins" -> return "Deri has won!"
        }
        return ""
    }
}