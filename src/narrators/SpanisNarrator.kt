package narrators

import behaviors.Behavior

class SpanisNarrator(name: String): Narrator(name), Behavior{
    override fun narrate(eventType: String): String {
        when(eventType){
            "welcome" -> return "Bienvenidos a DOTA 2!"
            "gamebegins" -> return "Que comience el juego!"
            "kill" -> return "Ha ocurrido una muerte!"
            "towerDown" -> return "Una torre ha caido!"
            "radiantWins" -> return "Radiant ha ganado!"
            "direWins" -> return "Deri ha ganado!"
        }
        return ""
    }
}