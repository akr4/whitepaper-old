package whitepaper.ui.main

import whitepaper.domain.memory.MemoryThreadRepositoryComponent
import org.scalatra.{FlashMapSupport, ScalatraServlet}
import whitepaper.infrastructure.mail.commons.CommonsMailSenderComponent
import whitepaper.infrastructure.clock.MutableClockComponent

class MainServlet
  extends ScalatraServlet
  with FlashMapSupport
  with ThreadController
  with MemoryThreadRepositoryComponent
  with MutableClockComponent
  with CommonsMailSenderComponent {

  val clock = new MutableClock
  val threadRepository = new MemoryThreadRepository
  val mailSender = new CommonsMailSender
  mailSender.start()

}
