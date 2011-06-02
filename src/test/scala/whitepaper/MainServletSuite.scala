package whitepaper

import org.scalatra.test.scalatest._
import org.scalatest.matchers._
import ui.main.{MainServlet}

class MainServletSuite extends ScalatraFunSuite with ShouldMatchers {
  addServlet(classOf[MainServlet], "/*")

  test("GET / returns status 200") {
    get("/threads") {
      status should equal(200)
    }
  }
}
