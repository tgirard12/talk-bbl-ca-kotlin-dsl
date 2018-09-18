import java.util.*

/**
 * Main class
 */
fun main() {
    fun Any.println() = print(this)

    select<User> {
        leftJoin<Bike>("userId").on<User>("id")

        where<Bike>("name") eq "VTT"
        where<User>("name") eq "thomas"

        limit(10)

    }.println()
}

// SELECT
operator fun SelectDsl.invoke(f: SelectDsl.() -> Unit): SelectDsl = SelectDsl().apply(f)

inline fun <reified T> select(f: SelectDsl.() -> Unit): SelectDsl = SelectDsl().apply {
    from = T::class.simpleName!!
    columns = T::class.java.declaredFields.map { it.name }
    this.f()
}

fun SelectDsl.limit(limit: Int) {
    this.limit = limit
}

// WHERE
inline fun <reified T> SelectDsl.where(column: String): WhereDsl {
    val whereDsl = WhereDsl(T::class.simpleName!!, column)
    this.where += whereDsl
    return whereDsl
}

infix fun WhereDsl.eq(value: String) {
    where = value
}

// JOIN
inline fun <reified T> SelectDsl.leftJoin(column: String): JoinDsl {
    val join = JoinDsl("LEFT", T::class.simpleName!!, column)
    this.joins.add(join)
    return join
}
inline fun <reified T> JoinDsl.on(column: String) {
    this.joinColumn = column
    this.joinTable = T::class.simpleName!!
}

data class User(
        val id: Long,
        val name: String,
        val mail: Int
)


data class Bike(
        val id: Long,
        val name: String,
        val userId: UUID
)