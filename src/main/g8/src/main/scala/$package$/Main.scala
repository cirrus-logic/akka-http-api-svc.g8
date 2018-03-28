package $package$

import akka.http.scaladsl.model.{ ContentTypes, HttpEntity }
import akka.http.scaladsl.server.{ HttpApp, Route }

object Server extends HttpApp {
  override def routes: Route =
    path("ping") {
      get {
        complete("pong")
      }
    }
}

object Main extends App {
  Server.startServer("localhost", 8080)
}
