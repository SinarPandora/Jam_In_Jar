package o.lartifa.jij.util

import io.smallrye.jwt.build.Jwt
import io.smallrye.mutiny.Uni
import o.lartifa.jij.model.request.SessionUser
import org.eclipse.microprofile.jwt.Claims
import org.eclipse.microprofile.jwt.JsonWebToken
import javax.enterprise.context.ApplicationScoped

object JWTProvider {
    fun generateToken(user: SessionUser): Uni<SessionUser> =
        Uni.createFrom().item {
            Jwt.issuer("https://example.com/issuer")
                .upn(user.name)
                .groups(setOf(user.role.name))
                .claim("uid", user.id!!.toString())
                .sign()
        }.onItem().transform {
            user.token = it
            user
        }
}
