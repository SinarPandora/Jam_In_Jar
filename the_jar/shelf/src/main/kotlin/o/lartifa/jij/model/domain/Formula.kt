package o.lartifa.jij.model.domain

import io.quarkus.mongodb.panache.MongoEntity
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoEntity
import o.lartifa.jij.enum.OSType

/**
 * 果酱版本
 *
 * Author: sinar 2021/4/13 19:49
 */
@MongoEntity(collection = "versions")
data class Formula(
    var version: String,
    var path: String,
    var alias: String?,
    var info: String?,
    var stable: Boolean = false,
    val brewStep: Map<OSType, String> = emptyMap()
) : ReactivePanacheMongoEntity()

object Formulas : ReactivePanacheMongoCompanion<Formula>
