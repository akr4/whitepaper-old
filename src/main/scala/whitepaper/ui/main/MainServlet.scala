package whitepaper.ui.main

import org.scalatra.{FlashMapSupport, ScalatraServlet}
import whitepaper.infrastructure.mail.commons.CommonsMailSenderComponent
import whitepaper.infrastructure.clock.MutableClockComponent
import org.squeryl.{SessionFactory, Session}
import whitepaper.domain.squeryl.{BbsDb, SquerylThreadRepositoryComponent}
import org.squeryl.adapters.PostgreSqlAdapter

class MainServlet
  extends ScalatraServlet
  with FlashMapSupport
  with ThreadController
  with SquerylThreadRepositoryComponent
  with MutableClockComponent
  with CommonsMailSenderComponent {

//  Class.forName("org.h2.Driver");
//  SessionFactory.concreteFactory = Some(() =>
//    Session.create(
//      java.sql.DriverManager.getConnection("jdbc:h2:~/example", "sa", ""),
//      new H2Adapter)
//  )
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
  val mailSender = new CommonsMailSender
  mailSender.start()

}
