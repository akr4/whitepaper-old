package whitepaper.ui.main

import org.scalatra.{FlashMapSupport, ScalatraServlet}
import whitepaper.infrastructure.mail.commons.CommonsMailSenderComponent
import whitepaper.infrastructure.clock.MutableClockComponent
import org.squeryl.{SessionFactory, Session}
import org.squeryl.adapters.PostgreSqlAdapter
import whitepaper.domain.squeryl.{SquerylMessageRepositoryComponent, BbsDb, SquerylThreadRepositoryComponent}

class MainServlet
  extends ScalatraServlet
  with FlashMapSupport
  with ThreadController
  with SquerylThreadRepositoryComponent
  with SquerylMessageRepositoryComponent
  with MutableClockComponent
  with CommonsMailSenderComponent {

  Class.forName("org.postgresql.Driver");
  SessionFactory.concreteFactory = Some(() => {
      val s = Session.create(
        java.sql.DriverManager.getConnection("jdbc:postgresql:whitepaper", "whitepaper", ""),
        new PostgreSqlAdapter)
      s.setLogger(sql => log(sql))
      s
    }
  )

  import org.squeryl.PrimitiveTypeMode._
  inTransaction {
//    BbsDb.drop
//    BbsDb.create
    BbsDb.printDdl
  }

  val clock = new MutableClock
  val threadRepository = new SquerylThreadRepository
  val messageRepository = new SquerylMessageRepository
  val mailSender = new CommonsMailSender
  mailSender.start()

}
