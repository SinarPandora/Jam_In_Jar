package o.lartifa.jij.service

import at.favre.lib.crypto.bcrypt.BCrypt
import io.smallrye.mutiny.Uni
import o.lartifa.jij.constant.Const
import o.lartifa.jij.constant.ErrMsg
import o.lartifa.jij.exception.JIJBusinessException
import o.lartifa.jij.model.domain.User
import o.lartifa.jij.model.domain.Users
import o.lartifa.jij.model.request.SessionUser
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped
import kotlin.random.Random

/**
 * 用户服务
 *
 * Author: sinar 2021/4/13 20:45
 */
@ApplicationScoped
class UserService(
    val hasher: BCrypt.Hasher,
    val verifyer: BCrypt.Verifyer
) {
    private val randomPasswordGenerator: Random = Random(System.currentTimeMillis())

    /**
     * 验证用户
     *
     * @param name 用户名
     * @param password 用户密码
     * @return 用户数据（未找到时为空）
     */
    fun authUser(name: String, password: String): Uni<SessionUser?> =
        this.get(name)
            .onItem().transform {
                it?.let {
                    val verify: BCrypt.Result = verifyer.verify(password.toCharArray(), it.pass.toCharArray())
                    if (verify.verified) {
                        SessionUser(
                            id = it.id?.toString(),
                            name = it.name,
                            role = it.role,
                            info = it.info
                        )
                    } else null
                }
            }

    /**
     * 通过用户名获取用户
     *
     * @param name 用户名
     * @return 查找到的用户
     */
    fun get(name: String): Uni<User?> = Users.find(Const.Field.User.Name, name).firstResult()

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
    fun register(user: SessionUser): Uni<String> =
        Uni.createFrom().deferred {
            if (!SessionUser.validate(user)) {
                throw JIJBusinessException(ErrMsg.WarningInfo)
            }
            this.get(user.name)
        }.onItem().transform {
            it?.let {
                // 不暴露用户名
                throw JIJBusinessException(ErrMsg.WarningInfo)
            }
            randomPasswordGenerator.nextInt(100_000, 999_999).toString()
        }
            .onItem().transform {
                User(
                    name = user.name,
                    pass = hasher.hashToString(Const.Auth.BcryptCost, it.toCharArray()),
                    info = user.info
                ).persist()
                it
            }

    /**
     * 更新用户信息（用户侧）
     *
     * @param userId 用户 ID
     * @param user 会话用户
     * @return 更新后的用户
     */
    fun updateInfo(userId: String, user: SessionUser): Uni<SessionUser> =
        this.getById(userId)
            .onItem()
            .transform {
                it?.let {
                    it.name = user.name
                    it.info = user.info
                    it.update()
                }
                user
            }

    /**
     * 获取头像
     *
     * @param userId 用户 ID
     * @return 头像数据
     */
    fun getPhoto(userId: String): Uni<String?> =
        this.getById(userId)
            .onItem()
            .transform { it?.photo }

    /**
     * 更新头像
     *
     * @param userId 用户 ID
     * @param data 头像数据
     */
    fun updatePhoto(userId: String, data: String): Uni<Unit> =
        this.getById(userId)
            .onItem()
            .transform {
                it?.let {
                    it.photo = data
                    it.update()
                }
            }

    /**
     * 更新用户信息（管理员侧）
     *
     * @param userId 用户 ID
     * @param user 用户数据
     * @return 更新后的用户数据
     */
    fun updateInfo(userId: String, user: User): Uni<User?> =
        this.getById(userId)
            .onItem()
            .transform {
                it?.let {
                    it.name = user.name
                    it.role = user.role
                    it.info = user.info
                    it.active = user.active
                    it.update()
                }
                it
            }

    /**
     * 禁用用户
     *
     * @param userId 用户 ID
     * @return 操作结果
     */
    fun inactiveUser(userId: String): Uni<Unit> =
        this.getById(userId)
            .onItem()
            .transform {
                it?.let {
                    it.active = false
                    it.update()
                }
            }
}
