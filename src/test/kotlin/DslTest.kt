import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec


class DslTest : WordSpec() {

    init {
/*
        "SELECT test simple" should {
            "select User" {
                select<User> { }.sql shouldBe """SELECT id, name, mail
                                                |FROM User
                                                """.trimMargin()

            }
            "select User an limit" {
                select<User> {
                    limit(10)
                }.sql shouldBe """SELECT id, name, mail
                    |FROM User
                    |LIMIT 10
                """.trimMargin()

            }
        }
        "SELECT where" should {
            "with two where" {
                select<User> {
                    where<User>("id").eq("10")
                    where<User>("name").eq("thomas")
                }.sql shouldBe """SELECT id, name, mail
                    |FROM User
                    |WHERE User.id = '10'
                    |AND User.name = 'thomas'
                """.trimMargin()
            }
        }
        "SELECT full test" should {
            "join, where and limit" {
                select<User> {
                    leftJoin<Bike>("userId").on<User>("id")

                    where<Bike>("name") eq "VTT"
                    where<User>("name") eq "thomas"

                    limit(10)
                }.sql shouldBe """SELECT id, name, mail
                                    |FROM User
                                    |LEFT JOIN Bike on Bike.userId = User.id
                                    |WHERE Bike.name = 'VTT'
                                    |AND User.name = 'thomas'
                                    |LIMIT 10"""
                        .trimMargin()
            }
        }
*/
    }
}