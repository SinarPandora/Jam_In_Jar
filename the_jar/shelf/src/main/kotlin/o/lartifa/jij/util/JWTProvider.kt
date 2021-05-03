package o.lartifa.jij.util

import io.smallrye.jwt.build.Jwt
import io.smallrye.mutiny.Uni
import o.lartifa.jij.constant.Const
import o.lartifa.jij.model.request.SessionUser
import org.eclipse.microprofile.config.inject.ConfigProperty
import javax.enterprise.context.ApplicationScoped

/**
 * JWT token 生成器
 *
 * Author: sinar
 * 2021/04/19 21:34:02
 */
@ApplicationScoped
class JWTProvider(@ConfigProperty(name = "jij.site.jwt-issuer", defaultValue = "http://localhost") val issuer: String) {

    /**
     * 生成 JWT token
     *
     * @param user 用户信息
     * @return JWT web token
     */
    fun generateToken(user: SessionUser): Uni<SessionUser> =
        Uni.createFrom().item {
            Jwt.issuer(issuer)
                .upn(user.name)
                .groups(setOf(user.role.name))
                .claim(Const.Auth.UID, user.id!!.toString())
                .sign()
        }.onItem().transform {
            user.token = it
            user
        }
}
