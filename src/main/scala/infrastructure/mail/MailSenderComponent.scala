package whitepaper.infrastructure.mail

import actors.Actor

trait MailSenderComponent {

  val mailSender: MailSender

  trait MailSender extends Actor {
    def send(mail: Mail)
  }

}
