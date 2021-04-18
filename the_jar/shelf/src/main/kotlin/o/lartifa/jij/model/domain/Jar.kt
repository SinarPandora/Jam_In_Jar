package o.lartifa.jij.model.domain

import io.quarkus.mongodb.panache.MongoEntity
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.reactive.ReactivePanacheMongoEntity
import o.lartifa.jij.enum.Status
import o.lartifa.jij.model.JamConfig
import o.lartifa.jij.model.Ports
import org.bson.types.ObjectId
import java.time.LocalDateTime

/**
 * 果酱实例
 *
 * Author: sinar 2021/4/13 19:39
 */
@MongoEntity(collection = "jars")
data class Jar(
    val userId: ObjectId,
    var alias: String?,
    var ports: Ports?,
    var versionId: ObjectId,
    var jamConfig: JamConfig,
    var updateTime: LocalDateTime = LocalDateTime.now(),
    var status: Status = Status.NotInit
) : ReactivePanacheMongoEntity()

object Jars : ReactivePanacheMongoCompanion<Jar>
