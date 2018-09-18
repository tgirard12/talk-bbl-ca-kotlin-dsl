/**
 *
 */
class JoinDsl(
        /**
         * LEFT - RIGHT ...
         */
        private val joinType: String,
        private val table: String,
        private val column: String
) {

    lateinit var joinTable: String
    lateinit var joinColumn: String

    override fun toString(): String = "$joinType JOIN $table on $table.$column = $joinTable.$joinColumn"
}
