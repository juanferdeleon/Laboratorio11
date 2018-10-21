import behaviors.Behavior
import narrators.EnglishNarrator
import narrators.SpanisNarrator

fun main(args: Array<String>) {

    var narratorOp = ""
    while (narratorOp != "3"){
        print(chooseNarratorMenu())
        narratorOp = readLine()!!
        when(narratorOp){
            "1" -> {
                val narrator = SpanisNarrator("Juan")
                print(narratorTurn(narrator, "welcome"))
            }
            "2" -> {
                val narrator = EnglishNarrator("John")
                print(narratorTurn(narrator, "welcome"))
            }
            "3" -> {
                println("El juego se cerrara.")
            }
            else -> println("Opcion ingresada no es valida.")
        }
    }

}

fun chooseNarratorMenu(): String{
    return """
            Menu
            1. English Narrator
            2. Spanish Narrator
            3. Salir
            Elija un narrador:
        """.trimIndent()
}

fun narratorTurn(narrator: Behavior, eventType: String): String{
    return narrator.narrate(eventType)
}