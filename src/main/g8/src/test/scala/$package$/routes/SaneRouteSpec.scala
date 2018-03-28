package $package$

import org.scalatest.{ Matchers, WordSpec }
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.http.scaladsl.server._
import Directives._

import $package$.Server

class SaneRouteSpec extends WordSpec with Matchers with ScalatestRouteTest {

  val testRoutes = Server.routes

  "For the sake of sanity the sane routes" should {
    "Return pong when pinged" in {
      Get("/ping") ~> testRoutes ~> check {
        responseAs[String] shouldEqual "pong"
      }
    }
  }
}
