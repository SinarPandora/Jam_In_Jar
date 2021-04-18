package o.lartifa.jij.service

import io.smallrye.mutiny.Uni
import o.lartifa.jij.model.domain.User
import o.lartifa.jij.model.domain.Users
import o.lartifa.jij.model.request.SessionUser
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped

/**
 * 用户服务
 *
 * Author: sinar 2021/4/13 20:45
 */
@ApplicationScoped
class UserService {
    /**
     * 通过用户名获取用户
     *
     * @param name 用户名
     * @return 查找到的用户
     */
    fun get(name: String): Uni<User?> = Users.find("name", name).firstResult()

    /**
     * 根据 ID 获取用户
     * @param userId 用户 ID
     * @return 查找到的用户
     */
    fun getById(userId: String): Uni<User?> = Users.findById(ObjectId(userId))

    /**
     * 注册用户
     *
     * @param user 用户信息
     * @return 随机密码
     */
    fun register(user: SessionUser): Uni<String> = TODO()

    /**
     * 更新用户信息（用户侧）
     *
     * @param user 会话用户
     * @return 更新后的用户
     */
    fun updateInfo(user: SessionUser): Uni<SessionUser> = TODO()

    /**
     * 获取头像
     *
     * @param userId 用户 ID
     * @return 头像数据
     */
    fun getPhoto(userId: String): Uni<String?> = TODO()

    /**
     * 更新用户信息（管理员侧）
     *
     * @param user 用户数据
     * @return 更新后的用户数据
     */
    fun updateInfo(user: User): Uni<User> = TODO()

    /**
     * 禁用用户
     *
     * @param userId 用户 ID
     * @return 操作结果
     */
    fun inactiveUser(userId: String): Uni<User> = TODO()
}
