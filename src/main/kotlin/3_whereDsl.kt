/**
 *
 */
class WhereDsl(
        private val table: String,
        private val column: String
) {

    lateinit var where: String

    override fun toString(): String = "$table.$column = '$where'"
}



