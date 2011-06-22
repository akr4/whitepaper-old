package whitepaper.domain.squeryl

import org.joda.time.DateTime
import org.squeryl.dsl.ManyToOne

class Message(
  val ownerId: Long, // User.id
  val threadId: Long, // Thread.id
  val body: String,
  val createdAt: DateTime
) extends Entity {

  import whitepaper.domain.squeryl.BbsDb._

  lazy val owner: ManyToOne[User] = userToMessage.right(this)
  lazy val thread: ManyToOne[Thread] = threadToMessages.right(this)
}
