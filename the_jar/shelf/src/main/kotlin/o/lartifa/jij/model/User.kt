package o.lartifa.jij.model

import io.quarkus.mongodb.panache.MongoEntity
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity

/**
 * 用户
 *
 * Author: sinar
 * 2021/4/13 19:53
 */
@MongoEntity(collection = "users")
data class User(
    var name: String,
    var pass: String,
    var photo: String?,
    var role: String = Role.JamParent.name,
    var info: String = "",
) : PanacheMongoEntity() {
    companion object {
        enum class Role(name: String) {
            JamParent("果酱监护人"),
            ShelfAdmin("果酱罐管理人"),
        }
    }
}

object Users: PanacheMongoCompanion<User>
