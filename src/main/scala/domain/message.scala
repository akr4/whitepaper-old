package whitepaper.domain

import org.joda.time.DateTime

class Message(
  val ownerId: Long, // User.id
  val threadId: Long, // Thread.id
  val body: String,
  val createdAt: DateTime,
  var viewCount: Int
) {
  lazy val owner: User = new User("user1") // dummy
  lazy val thread: Thread = new Thread("thread1") // dummy

  def viewed(user: User) {
    viewCount += 1
  }
}
