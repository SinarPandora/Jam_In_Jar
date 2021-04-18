package o.lartifa.jij.model.domain

import io.quarkus.mongodb.panache.MongoEntity
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoEntity
import o.lartifa.jij.enum.Role

/**
 * 用户
 *
 * Author: sinar 2021/4/13 19:53
 */
@MongoEntity(collection = "users")
data class User(
    var name: String,
    var pass: String,
    var photo: String?,
    var role: Role = Role.JamParent,
    var info: String = "",
) : ReactivePanacheMongoEntity()

object Users : ReactivePanacheMongoCompanion<User>
