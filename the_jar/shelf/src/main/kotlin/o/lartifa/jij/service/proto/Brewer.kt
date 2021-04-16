package o.lartifa.jij.service.proto

import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import o.lartifa.jij.model.Formula
import o.lartifa.jij.model.JamConfig
import o.lartifa.jij.model.Jar

/**
 * 酿造者
 *
 * Author: sinar
 * 2021/4/16 00:02
 */
interface Brewer {
    /**
     * 酿造果酱
     *
     * @param formula 果酱配方
     * @param userId  用户 ID
     */
    fun brew(formula: Formula, userId: String): Uni<Jar>

    /**
     * 获取酿造状态
     *
     * @param userId 用户 ID
     * @return 酿造状态：[别名/ObjectId -> 状态]组
     */
    fun statusOf(userId: String): Multi<Pair<String, Jar.Companion.Status>>

    /**
     * 调味（更新果酱配置）
     *
     * @param jarConfig 果酱配置
     * @param jarId 罐子 ID
     * @return 操作结果
     */
    fun seasonOf(jarConfig: JamConfig, jarId: String): Uni<Unit>
}
