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
data class Formula(
    var version: String,
    var path: String,
    var alias: String?,
    var info: String?,
    var stable: Boolean = false,
    /**
     * 系统类型 -> 启动指令
     */
    val brewStep: Map<String, String> = emptyMap()
) : PanacheMongoEntity()

object Formulas : PanacheMongoCompanion<Formula>
