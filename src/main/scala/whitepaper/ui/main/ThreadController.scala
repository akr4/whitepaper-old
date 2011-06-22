package whitepaper.ui.main

import whitepaper.infrastructure.Transactional
import org.scalatra.{CsrfTokenSupport, FlashMapSupport, ScalatraKernel}
import whitepaper.infrastructure.mail.{Address, Mail, MailSenderComponent}
import javax.servlet.ServletContext
import whitepaper.domain.squeryl.ThreadRepositoryComponent

trait ThreadController
  extends ScalatraKernel
  with FlashMapSupport
  with Controller
  with Transactional
  with CsrfTokenSupport {
  self: ThreadRepositoryComponent with MailSenderComponent
    { def servletContext: ServletContext }
  =>

  import org.squeryl.PrimitiveTypeMode._

  beforeAll {
    contentType = "text/html"
  }

  get("/") {
    flash += ("message" -> "Hello")
    redirect("/threads")
  }

  get("/threads") {
    val mail = new Mail("ThreadController", "this is a ThreadController.", List(Address("a@example.com", "user1")), List(), Address("b@example.com", "user2"))
    mailSender ! mail

    inTransaction {
      render("threads",
        Map(
          "threads" -> threadRepository.findAll().map { t => new ThreadViewAdapter(t) },
          "message" -> flash.getOrElse("message", "welcome back!"),
          "token" -> session.getOrElse("csrfToken", "token")
        ))
    }
  }

  get("/threads/:id") {
    inTransaction {
      val id = params("id").toLong
      threadRepository.find(id) match {
        case Some(t) => render("thread", Map("thread" -> new ThreadViewAdapter(t)))
        case None => status(404)
      }
    }
  }

}
