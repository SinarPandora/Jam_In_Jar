package o.lartifa.jij.api

import io.smallrye.mutiny.Uni
import o.lartifa.jij.model.request.NameAndPass
import o.lartifa.jij.service.UserService
import o.lartifa.jij.util.JWTProvider
import javax.annotation.security.PermitAll
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

/**
 * JWT API
 *
 * Author: sinar
 * 2021/4/16 22:30
 */
@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class JWTApi(
    val userService: UserService,
    val jwtProvider: JWTProvider
) {
    /**
     * 获取 token
     * @param pair 用户名 & 密码对
     * @return 带有 Token 的用户信息
     */
    @POST
    @PermitAll
    @Path("token")
    fun login(pair: NameAndPass): Uni<Response> =
        userService.authUser(pair.name, pair.password)
            .flatMap {
                it?.let {
                    jwtProvider.generateToken(it)
                        .map { user ->
                            Response.ok(user)
                        }
                } ?: Uni.createFrom().item(Response.status(Response.Status.NOT_FOUND))
            }
            .map { it.build() }
}
