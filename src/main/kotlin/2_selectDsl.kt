/**
 *
 *
 *
 */
class SelectDsl {
    var columns = listOf<String>()
    var from: String = ""
    val joins = mutableListOf<JoinDsl>()
    val where = mutableListOf<WhereDsl>()
    var limit: Int? = null

    override fun toString(): String =
            """SELECT ${columns.joinToString(separator = ", ")}
                |FROM $from
                |${joins.joinLinesIfNotEmpty()}
                |${where.joinLinesIfNotEmpty(prefix = "WHERE ", separator = "\nAND ")}
                |${if (limit != null) "LIMIT $limit" else ""}
            """.trimMarginAndEmptyLines()

    val sql get() = toString()
}


/**
 * Formatter methods
 */
private fun List<Any>.joinLinesIfNotEmpty(prefix: String = "", separator: String = "\n"): String =
        if (this.isNotEmpty()) this.joinToString(prefix = prefix, separator = separator, postfix = "\n")
        else ""

private fun String.trimMarginAndEmptyLines() =
        this.trimMargin()
                .lines()
                .map { if (it.isBlank()) null else it }.mapNotNull { it }
                .joinToString(separator = "\n")
