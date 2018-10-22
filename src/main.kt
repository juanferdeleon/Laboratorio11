import behaviors.Behavior
import buildings.Tower
import game.Game
import heroes.Heroe
import narrators.EnglishNarrator
import narrators.Narrator
import narrators.SpanisNarrator
import teams.Team

fun main(args: Array<String>) {

    var narratorOp = ""
    var heroes: MutableList<Heroe> = mutableListOf(
            Heroe(name = "EARTHSHAKER", type = "Fuerza"),
            Heroe(name = "SVEN", type = "Fuerza"),
            Heroe(name = "TINY", type = "Fuerza"),
            Heroe(name = "KUNKKA", type = "Fuerza"),
            Heroe(name = "BEASTMASTER", type = "Fuerza"),
            Heroe(name = "DRAGON KNIGHT", type = "Fuerza"),
            Heroe(name = "CLOCKWERK", type = "Fuerza"),
            Heroe(name = "ANTI-MAGE", type = "Agilidad"),
            Heroe(name = "DROW RANGER", type = "Agilidad"),
            Heroe(name = "JUGGERNAUT", type = "Agilidad"),
            Heroe(name = "MIRANA", type = "Agilidad"),
            Heroe(name = "MORPHLING", type = "Agilidad"),
            Heroe(name = "PHANTOM LANCER", type = "Agilidad"),
            Heroe(name = "VENGEFUL SPIRIT", type = "Agilidad"),
            Heroe(name = "CRYSTAL MAIDEN", type = "Inteligencia"),
            Heroe(name = "PUCK", type = "Inteligencia"),
            Heroe(name = "STORM SPIRIT", type = "Inteligencia"),
            Heroe(name = "WINDRANGER", type = "Inteligencia"),
            Heroe(name = "ZEUS", type = "Inteligencia"),
            Heroe(name = "LINA", type = "Inteligencia")
    )
    print(heroes.size)
    var radiant: ArrayList<Heroe> = ArrayList()
    var dire: ArrayList<Heroe> = ArrayList()
    var isRadiantTurn: Boolean = true
    var narrator: Narrator = Narrator("John")

    while (narratorOp != "3"){//Define que tipo de narrador se utilizara
        print(chooseNarratorMenu())
        narratorOp = readLine()!!
        when(narratorOp){
            "1" -> {
                narrator = EnglishNarrator("John")
                narratorOp = "3"
            }
            "2" -> {
                narrator = SpanisNarrator("Juan")
                narratorOp = "3"
            }
            else -> println("Opcion ingresada no es valida.")
        }
    }

    print(narratorTurn(narrator, "welcome"))
    var heroesQuant = 0
    while(heroesQuant <= 4){//Genera dos arrays seleccionados por los jugadores
        println("Heroes Disponibles:\n")
        for (i in 1..heroes.size){
            println("$i. ${heroes[i-1]}")
        }
        if (isRadiantTurn){
            print("\nRadiant escoja un heroe: ")
            var chosen = readLine()!!.toInt()
            radiant.add(heroes.removeAt(chosen-1))
            isRadiantTurn = !isRadiantTurn
        }else{
            print("\nDire escoja un heroe: ")
            var chosen = readLine()!!.toInt()
            dire.add(heroes.removeAt(chosen-1))
            isRadiantTurn = !isRadiantTurn
            heroesQuant++
        }
    }
    var game = createGame(narrator, radiant, dire)
    print(narratorTurn(narrator, "gamebegins"))

    var gameOp = ""
    while(gameOp != "3"){
        if(game.isRadiantTurn){
            print("\nEs turno de Radiant")
            if (!game.allTowersDown(game.dire)){
                print(menuDeJuego())
                gameOp = readLine()!!
                when (gameOp){
                    "1" -> {
                        print(narratorTurn(narrator, "kill"))
                        game.radiantKill()
                    }
                    "2" -> {
                        print(narratorTurn(narrator, "towerDown"))
                        game.direTowerDown()
                    }
                    "3" -> {
                        print(narratorTurn(narrator, "exit"))
                    }
                    else -> println("La opcion ingresada no es valida")
                }
            }else{
                println(menuSecundarioDeJuego())
                gameOp = readLine()!!
                when (gameOp){
                    "1" -> {
                        print(narratorTurn(narrator, "kill"))
                        game.radiantKill()
                    }
                    "2" -> {
                        print(narratorTurn(narrator, "ancientDown"))
                        game.direAncientDown()
                    }
                    "3" -> {
                        print(narratorTurn(narrator, "exit"))
                    }
                    else -> println("La opcion ingresada no es valida")
                }
            }
            game.changeTurn()
        }else{
            print("\nEs turno de Dire")
            if (!game.allTowersDown(game.radiant)){
                print(menuDeJuego())
                gameOp = readLine()!!
                when (gameOp){
                    "1" -> {
                        print(narratorTurn(narrator, "kill"))
                        game.direKill()
                    }
                    "2" -> {
                        print(narratorTurn(narrator, "towerDown"))
                        game.radiantTowerDown()
                    }
                    "3" -> {
                        print(narratorTurn(narrator, "exit"))
                    }
                    else -> println("La opcion ingresada no es valida")
                }
            }else{
                println(menuSecundarioDeJuego())
                gameOp = readLine()!!
                when (gameOp){
                    "1" -> {
                        print(narratorTurn(narrator, "kill"))
                        game.direKill()
                    }
                    "2" -> {
                        print(narratorTurn(narrator, "ancientDown"))
                        game.radiantAncientDown()
                    }
                    "3" -> {
                        print(narratorTurn(narrator, "exit"))
                    }
                    else -> println("La opcion ingresada no es valida")
                }
            }
            game.changeTurn()
        }
        if(game.checkWinner(game.radiant)){
            print("Dire ha ganado!")
            gameOp = "3"
        }
        if(game.checkWinner(game.dire)){
            print("Radiant ha ganado!")
            gameOp = "3"
        }
    }

}

fun createGame(narrator: Narrator, radiant: ArrayList<Heroe>, dire: ArrayList<Heroe>): Game{
    var towersArray: MutableList<Tower> = mutableListOf(Tower(false), Tower(false), Tower(false), Tower(false), Tower(false))
    var radiantTeam = Team(heroesArray = radiant, towersArray = towersArray)
    var direTeam = Team(heroesArray = dire, towersArray = towersArray)
    var game = Game(narrator, radiantTeam, direTeam)
    return game
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

fun menuDeJuego(): String{
    return """

        Menu
        1. Matar a un jugador
        2. Derribar a una torre
        3. Salir
        Ingrese una opcion:
    """.trimIndent()
}

fun menuSecundarioDeJuego(): String{
    return """

        Menu
        1. Matar a un jugador
        2. Derribar Anciano
        3. Salir
        Ingrese una opcion:
    """.trimIndent()
}