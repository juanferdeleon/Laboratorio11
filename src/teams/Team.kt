package teams

import buildings.Ancient
import buildings.Tower
import heroes.Heroe

class Team constructor (
        private val heroesArray: MutableList<Heroe> = ArrayList(),
        private val towersArray: MutableList<Tower> = ArrayList(),
        private var ancient: Ancient = Ancient(false),
        private var deads: Int = 0,
        private var towersDown: Int = 0
){

    fun oneDead(){
        this.deads ++
    }

    fun checkTowers(): Int{
        var towerCtr = towersArray.size
        towersArray.forEach {
            if (it.isDead){
                towerCtr --
            }
        }
        return towerCtr
    }

    fun towerDown(){
        towersArray[towersDown].isDead = !towersArray[towersDown].isDead
        this.towersDown ++
    }

    fun ancientDown(){
        this.ancient.isDead = !ancient.isDead
    }

    fun checkAncient(): Boolean{
        return ancient.isDead
    }
}