package o.lartifa.jij.model

import io.quarkus.mongodb.panache.MongoEntity
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity

/**
 * 果酱版本
 *
 * Author: sinar
 * 2021/4/13 19:49
 */
@MongoEntity(collection = "versions")
data class Version(
    var version: String,
    var path: String,
    var stable: Boolean = false
) : PanacheMongoEntity()

object Versions : PanacheMongoCompanion<Version>
