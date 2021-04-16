package o.lartifa.jij.model

import io.quarkus.mongodb.panache.MongoEntity
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import org.bson.types.ObjectId
import java.time.LocalDateTime

/**
 * 果酱实例
 *
 * Author: sinar
 * 2021/4/13 19:39
 */
@MongoEntity(collection = "jars")
data class Jar(
    val userId: ObjectId,
    var alias: String?,
    var ports: Ports?,
    var versionId: ObjectId,
    var jamConfig: JamConfig,
    var updateTime: LocalDateTime = LocalDateTime.now(),
    var status: String = Status.NotInit.name
) : PanacheMongoEntity() {
    companion object {
        data class Ports(val toMirai: Int, val fromMirai: Int)
        enum class Status(name: String) {
            NotInit("未初始化"),
            Creating("正在创建"),
            Starting("正在启动"),
            Running("运行中"),
            Stopping("正在停止"),
            Stopped("已停止"),
            Terminated("已销毁"),
        }
    }
}

object Jars : PanacheMongoCompanion<Jar>
