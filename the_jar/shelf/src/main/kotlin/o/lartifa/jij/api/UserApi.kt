package o.lartifa.jij.api

import o.lartifa.jij.model.request.SessionUser
import o.lartifa.jij.service.UserService
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

/**
 * 用户 API
 *
 * Author: sinar 2021/4/13 20:50
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class UserApi(userService: UserService) {

    @POST
    fun test(user: SessionUser) {
        println(user)
    }
}
