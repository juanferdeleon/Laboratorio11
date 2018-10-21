package teams

import buildings.Ancient
import buildings.Tower
import heroes.Heroe

class Team constructor (
        private val heroesArray: ArrayList<Heroe> = ArrayList(),
        private val towersArray: ArrayList<Tower> = ArrayList(),
        private val ancient: Ancient
)