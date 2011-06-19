package whitepaper.domain

import org.joda.time.DateTime
import org.squeryl.KeyedEntity
import org.squeryl.dsl.{ManyToOne, OneToMany}

class Message(
  val id: Long,
  val ownerId: Long, // User.id
  val body: String,
  val createdAt: DateTime
) extends KeyedEntity[Long] {

  import whitepaper.domain.squeryl.AppSchema._

  lazy val owner: ManyToOne[User] = userToMessage.right(this)
}
