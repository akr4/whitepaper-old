package whitepaper.ui.main

import whitepaper.domain.memory.MemoryThreadRepositoryComponent
import org.scalatra.{FlashMapSupport, ScalatraServlet}
import whitepaper.infrastructure.mail.commons.CommonsMailSenderComponent
import whitepaper.infrastructure.clock.MutableClockComponent
import org.squeryl.adapters.H2Adapter
import org.squeryl.{SessionFactory, Session}
import whitepaper.domain.squeryl.{AppSchema, SquerylThreadRepositoryComponent}

class MainServlet
  extends ScalatraServlet
  with FlashMapSupport
  with ThreadController
  with SquerylThreadRepositoryComponent
  with MutableClockComponent
  with CommonsMailSenderComponent {

  Class.forName("org.h2.Driver");
  SessionFactory.concreteFactory = Some(() =>
    Session.create(
      java.sql.DriverManager.getConnection("jdbc:h2:~/example", "sa", ""),
      new H2Adapter)
  )

  import org.squeryl.customtypes.CustomTypesMode._
  inTransaction {
    AppSchema.drop
    AppSchema.create
    AppSchema.printDdl
  }

  val clock = new MutableClock
  val threadRepository = new SquerylThreadRepository
  val mailSender = new CommonsMailSender
  mailSender.start()

}
