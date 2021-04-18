package o.lartifa.jij.model.request

import o.lartifa.jij.model.domain.User

/**
 * 会话中的用户
 *
 * Author: sinar 2021/4/16 22:30
 */
data class SessionUser(
    val id: String?,
    var name: String,
    var role: User.Companion.Role,
    var info: String = "",
) {
    companion object {
        fun validate(user: SessionUser): Boolean {
            val (id, name, role, info) = user
            TODO()
        }
    }
}
