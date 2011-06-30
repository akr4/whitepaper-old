package whitepaper.domain.squeryl

import org.joda.time.DateTime
import org.squeryl.dsl.OneToMany
import org.scala_tools.time.Imports._

class Thread(
  val title: String
) extends Entity {

  import whitepaper.domain.squeryl.BbsDb._

  def write(writtenBy: User, body: String) {
  }

  private lazy val _messages: OneToMany[Message] = threadToMessages.left(this)

  lazy val messages = _messages.toList
  lazy val firstMessage: Message = _messages.toList.sortWith(_.id < _.id).head
  lazy val owner: User = firstMessage.owner.head // TODO: too many dots
  lazy val body: String = firstMessage.body
  lazy val createdAt: DateTime = new DateTime // firstMessage.createdAt
  lazy val comments = _messages.tail.toList

}
