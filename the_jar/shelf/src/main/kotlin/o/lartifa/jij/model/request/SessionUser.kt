package o.lartifa.jij.model.request

import o.lartifa.jij.enum.Role

/**
 * 会话中的用户
 *
 * Author: sinar 2021/4/16 22:30
 */
data class SessionUser(
    val id: String?,
    var name: String,
    var role: Role,
    var info: String = "",
    var token: String? = null
) {
    companion object {
        fun validate(user: SessionUser): Boolean = user.name.isNotEmpty()
    }
}
