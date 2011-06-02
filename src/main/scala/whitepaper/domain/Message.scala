package whitepaper.domain

import org.joda.time.DateTime

class Message(
  val id: EntityId,
  val owner: User,
  val body: String,
  val createdAt: DateTime
) extends Entity {
  println(id.simpleString)
}

object Message {
  def apply(owner: User, body: String, createdAt: DateTime): Message =
    new Message(EntityId.newEntityId, owner, body, createdAt)
}
