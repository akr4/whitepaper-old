package whitepaper.infrastructure.mail.commons

import actors.Actor
import whitepaper.infrastructure.mail.{MailSenderComponent, Mail}
import whitepaper.infrastructure.log.Logging

trait CommonsMailSenderComponent extends MailSenderComponent {
  class CommonsMailSender extends MailSender with Actor with Logging {
    debug("initialized: " + this)

    def send(mail: Mail) {
      info(mail)
      new CommonsEmailMail(mail).toEmail.send()
    }

    def act() {
      react {
        case mail: Mail => try { send(mail) } catch { case _ => }
        act()
      }
    }
  }
}
