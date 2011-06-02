package whitepaper.infrastructure.mail.commons

import org.apache.commons.mail.{SimpleEmail, Email}
import whitepaper.infrastructure.mail.{Address, Mail}

case class CommonsEmailMail(mail: Mail) extends Mail(mail.subject, mail.body, mail.toAddresses, mail.ccAddresses, mail.fromAddress) {

  def toEmail: Email = {
    val email = new SimpleEmail
    email.setSubject(subject)
    email.setContent(body, "text/plain")
    toAddresses.foreach(a => email.addTo(a.email, a.name))
    ccAddresses.foreach(a => email.addCc(a.email, a.name))
    email.setFrom(fromAddress.email, fromAddress.name)
    email.setHostName("localhost")
    email.setDebug(true)
    email
  }
}
