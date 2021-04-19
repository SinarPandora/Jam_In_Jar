package o.lartifa.jij.api

import io.smallrye.mutiny.Uni
import o.lartifa.jij.exception.JIJBusinessException
import o.lartifa.jij.model.request.NameAndPass
import o.lartifa.jij.model.request.SessionUser
import o.lartifa.jij.util.JWTProvider
import o.lartifa.jij.service.UserService
import javax.annotation.security.PermitAll
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class JWTApi(
    val userService: UserService
) {
    @POST
    @PermitAll
    @Path("token")
    fun login(pair: NameAndPass): Uni<SessionUser> =
        userService.authUser(pair.name, pair.password)
            .onItem().transform {
                if (it == null) {
                    throw JIJBusinessException("用户名或密码错误")
                }
                it
            }
            .onItem().transformToUni(JWTProvider::generateToken)
}
