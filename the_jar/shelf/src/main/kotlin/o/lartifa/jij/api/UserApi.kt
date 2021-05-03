package o.lartifa.jij.api

import io.smallrye.mutiny.Uni
import o.lartifa.jij.constant.Const
import o.lartifa.jij.model.request.SessionUser
import o.lartifa.jij.service.UserService
import org.eclipse.microprofile.jwt.JsonWebToken
import javax.enterprise.context.RequestScoped
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.core.SecurityContext

/**
 * 用户 API
 *
 * Author: sinar
 * 2021/4/13 20:50
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
class UserApi(
    val userService: UserService,
    val jwt: JsonWebToken
) {

    /**
     * 获取会话中的用户
     *
     * @param ctx SecurityContext 安全上下文
     * @return 会话中的用户
     */
    @GET
    fun getSessionUser(ctx: SecurityContext?): Uni<Response> {
        val uid: String = ctx?.userPrincipal?.let {
            jwt.getClaim(Const.Auth.UID)
        } ?: return Uni.createFrom().item(
            Response.status(Response.Status.UNAUTHORIZED).build()
        )

        return userService.getById(uid)
            .map {
                it?.let {
                    Response.ok(
                        SessionUser(
                            id = it.id.toString(),
                            name = it.name,
                            role = it.role,
                            info = it.info,
                            token = null
                        )
                    )
                } ?: Response.status(Response.Status.NOT_FOUND)
            }
            .map { it.build() }
    }
}
