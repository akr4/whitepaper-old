package whitepaper.domain

import org.scala_tools.time.Imports._

class Thread(
  val title: String
) {
  def write(writtenBy: User, body: String) {
  }

  lazy val messages: List[Message] = List(new Message(1, 1, "message1", new DateTime, 0), new Message(1, 1, "message2", new DateTime, 0))
  lazy val firstMessage: Message = messages.toList.sortWith(_.createdAt < _.createdAt).head
  lazy val owner: User = firstMessage.owner
  lazy val body: String = firstMessage.body
  lazy val createdAt: DateTime = new DateTime // firstMessage.createdAt
  lazy val comments = messages.tail.toList

}
