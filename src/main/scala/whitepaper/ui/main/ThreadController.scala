package whitepaper.ui.main

import auth.{AuthenticationSupport, MyUser}
import javax.servlet.ServletContext
import whitepaper.domain.{ThreadRepositoryComponent}
import whitepaper.infrastructure.Transactional
import org.scalatra.{CsrfTokenSupport, FlashMapSupport, ScalatraKernel}
import whitepaper.infrastructure.mail.{Address, Mail, MailSenderComponent}
import org.scalatra.auth.strategy.BasicAuthSupport

trait ThreadController
  extends ScalatraKernel
  with FlashMapSupport
  with Controller
  with Transactional
  with CsrfTokenSupport
  with AuthenticationSupport {
  self: ThreadRepositoryComponent with MailSenderComponent
    { def servletContext: ServletContext }
  =>

  beforeAll {
    contentType = "text/html"
  }

  get("/") {
    flash += ("message" -> "Hello")
    redirect("/threads")
  }

  get("/threads") {
    basicAuth()

    val mail = new Mail("ThreadController", "this is a ThreadController.", List(Address("a@example.com", "user1")), List(), Address("b@example.com", "user2"))
    mailSender ! mail

    withTransaction {
      render("threads",
        Map(
          "threads" -> threadRepository.findAll().map { t => new ThreadViewAdapter(t) },
          "message" -> flash.getOrElse("message", "welcome back!"),
          "token" -> session.getOrElse("csrfToken", "token")
        ))
    }
  }

}
