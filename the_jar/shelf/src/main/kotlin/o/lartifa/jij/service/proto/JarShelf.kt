package o.lartifa.jij.service.proto

import io.smallrye.mutiny.Multi
import io.smallrye.mutiny.Uni
import o.lartifa.jij.enum.Status
import o.lartifa.jij.model.domain.Jar
import org.bson.types.ObjectId

/**
 * 果酱架
 *
 * Author: sinar 2021/4/15 00:11
 */
interface JarShelf {

    /**
     * 该用户拥有的所有果酱罐
     *
     * @param userId 用户 ID
     * @return 果酱罐
     */
    fun jarsBelongTo(userId: String): Multi<Jar>

    /**
     * 获取指定的罐子
     *
     * @param jarId 罐子 ID
     * @return 罐子
     */
    fun get(jarId: String): Uni<Jar?>

    /**
     * 获取指定的罐子
     *
     * @param userId 用户 ID
     * @param aliasOrId 别名/ObjectId
     * @return 罐子
     */
    fun get(userId: ObjectId, aliasOrId: String): Uni<Jar?>

    /**
     * 把果酱罐放在架子上
     *
     * @param jar 果酱罐
     * @return 操作结果
     */
    fun putJarOnShelf(jar: Jar): Uni<Unit>

    /**
     * 给罐子贴标签（修改别名）
     *
     * @param jarId 罐子 ID
     * @param alias 标签（别名）
     * @return 操作结果
     */
    fun putLabelOn(alias: String, jarId: String): Uni<Unit>

    /**
     * 更新罐子的状态
     *
     * @param status 状态
     * @param jarId 罐子 ID
     * @return 操作结果
     */
    fun updateStatusOf(status: Status, jarId: String): Uni<Unit>

    /**
     * 丢弃取指定罐子
     *
     * @param jarId 罐子 ID
     * @return 操作结果
     */
    fun dropJar(jarId: String): Uni<Unit>
}
