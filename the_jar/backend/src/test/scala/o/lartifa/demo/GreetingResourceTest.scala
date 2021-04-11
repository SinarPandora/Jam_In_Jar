package o.lartifa.demo

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.response.ValidatableResponse
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class GreetingResourceTest {

    @Test
    def testHelloEndpoint(): ValidatableResponse = {
        given()
          .`when`().get("/hello-resteasy")
          .`then`()
             .statusCode(200)
             .body(`is`("Hello RESTEasy"))
    }

}
