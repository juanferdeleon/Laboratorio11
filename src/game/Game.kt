package game

import narrators.Narrator
import teams.Team

class Game (var narrator: Narrator,
            val radiant: Team,
            val dire: Team,
            var isRadiantTurn: Boolean = true)
{

    fun radiantAncientDown(){
        radiant.ancientDown()
    }

    fun direAncientDown(){
        dire.ancientDown()
    }

    fun radiantKill(){
        dire.oneDead()
    }

    fun direKill(){
        radiant.oneDead()
    }

    fun allTowersDown(team: Team): Boolean{
        if(team.checkTowers() == 0){
            return true
        }
        return false
    }

    fun direTowerDown(){
        dire.towerDown()
    }

    fun radiantTowerDown(){
        radiant.towerDown()
    }

    fun changeTurn(){
        this.isRadiantTurn = !isRadiantTurn
    }

}