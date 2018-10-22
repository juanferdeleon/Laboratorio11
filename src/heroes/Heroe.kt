package heroes

data class Heroe(val name: String, val type: String){
    override fun toString(): String {
        return """
            $name, $type
        """.trimIndent()
    }
}