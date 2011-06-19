package whitepaper.domain

import org.joda.time.DateTime
import org.squeryl.dsl.{ManyToOne, OneToMany}
import org.squeryl.KeyedEntity

class Thread(
  val id: Long,
  val title: String,
  val messageId: Long
) extends KeyedEntity[Long] {

  import whitepaper.domain.squeryl.AppSchema._

  def write(writtenBy: User, body: String) {
  }

  lazy val message: ManyToOne[Message] = messageToThread.right(this)
  def owner: User = message.head.owner.head // TODO: too many dots
  def body: String = message.head.body
  def createdAt: DateTime = message.head.createdAt

}
