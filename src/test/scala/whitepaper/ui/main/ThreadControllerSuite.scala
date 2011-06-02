package whitepaper.ui.main

import org.scalatest.{AbstractSuite, FunSuite}
import org.scalatra.test.scalatest.ScalatraSuite
import javax.servlet.ServletContext

class ThreadControllerSuite extends FunSuite {

  trait ServletContextSupplier {
    def servletContext: ServletContext = null
  }
}