package whitepaper.domain.squeryl

import org.squeryl.dsl.ManyToOne
import java.util.Date

class Message(
  val ownerId: Long, // User.id
  val threadId: Long, // Thread.id
  val body: String,
  val createdAt: Date,
  var viewCount: Int
) extends Entity {

  import whitepaper.domain.squeryl.BbsDb._

  lazy val owner: ManyToOne[User] = userToMessage.right(this)
  lazy val thread: ManyToOne[Thread] = threadToMessages.right(this)

  def viewed(user: User) {
    viewCount += 1
  }
}
