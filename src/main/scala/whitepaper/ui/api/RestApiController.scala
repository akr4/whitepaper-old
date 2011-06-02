package whitepaper.ui.api

import org.scalatra.ScalatraKernel
import org.codehaus.jackson.map.ObjectMapper

trait RestApiController extends ScalatraKernel {
  val objectMapper = new ObjectMapper()

  get("/api/threads") {
    
  }
}