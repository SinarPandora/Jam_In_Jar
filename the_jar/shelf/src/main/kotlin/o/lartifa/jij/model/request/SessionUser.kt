package o.lartifa.jij.model.request

import o.lartifa.jij.model.User

/**
 * 会话中的用户
 *
 * Author: sinar
 * 2021/4/16 22:30
 */
data class SessionUser(
    val id: String,
    var name: String,
    var role: String = User.Companion.Role.JamParent.name,
    var info: String = "",
)
