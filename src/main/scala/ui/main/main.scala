package whitepaper.ui.main

import whitepaper.infrastructure.mail.commons.CommonsMailSenderComponent
import whitepaper.infrastructure.clock.MutableClockComponent
import whitepaper.infrastructure.log.Logging
import whitepaper.domain.{DummyMessageRepositoryComponent, DummyThreadRepositoryComponent}

trait ScalateConfig {
  import org.fusesource.scalate.TemplateEngine
  import org.fusesource.scalate.layout.DefaultLayoutStrategy
  implicit val engine = new TemplateEngine(List(
    new java.io.File("src/main/webapp/WEB-INF/scalate/templates")
  ))
  engine.layoutStrategy = new DefaultLayoutStrategy(engine)
}

class MainPlan
  extends unfiltered.filter.Plan
  with ThreadController
  with DummyThreadRepositoryComponent
  with DummyMessageRepositoryComponent
  with MutableClockComponent
  with CommonsMailSenderComponent
  with ScalateConfig
  with Logging {

  val clock = new MutableClock
  val threadRepository = new DummyThreadRepository
  val messageRepository = new DummyMessageRepository
  val mailSender = new CommonsMailSender
  mailSender.start()

  def intent = {
    threadController
  }

}
