package whitepaper.ui.main

import whitepaper.infrastructure.mail.commons.CommonsMailSenderComponent
import whitepaper.infrastructure.clock.MutableClockComponent
import whitepaper.infrastructure.log.Logging
import whitepaper.domain.{DummyMessageRepositoryComponent, DummyThreadRepositoryComponent}
import org.fusesource.scalate.TemplateEngine
import org.fusesource.scalate.servlet.ServletTemplateEngine
import org.fusesource.scalate.layout.DefaultLayoutStrategy

class MainPlan
  extends unfiltered.filter.Plan
  with ThreadController
  with DummyThreadRepositoryComponent
  with DummyMessageRepositoryComponent
  with MutableClockComponent
  with CommonsMailSenderComponent
  with Logging {

  val clock = new MutableClock
  val threadRepository = new DummyThreadRepository
  val messageRepository = new DummyMessageRepository
  val mailSender = new CommonsMailSender
  mailSender.start()

  override def init(config: javax.servlet.FilterConfig) {
    super.init(config)
  }

  def intent = {
    val engine = new ServletTemplateEngine(config)
    engine.layoutStrategy = new DefaultLayoutStrategy(engine)

    debug("start main")
    threadController(engine, config)
  }

}
