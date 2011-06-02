package whitepaper.domain

import org.joda.time.DateTime


class Thread(
  val id: EntityId,
  val title: String,
  val message: Message
) extends Entity {

  private var _messages = List[Message]()

  def write(writtenBy: User, body: String) {
    _messages ::= Message(writtenBy, body, new DateTime)
  }

  def owner: User = message.owner
  def body: String = message.body
  def createdAt: DateTime = message.createdAt
  def messages = _messages

}

object Thread {
  def apply(title: String, message: Message): Thread = new Thread(EntityId.newEntityId, title, message)
}
