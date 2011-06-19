package whitepaper.domain.squeryl

import org.squeryl.Schema
import whitepaper.domain._

object AppSchema extends Schema {

  import org.squeryl.customtypes.CustomTypesMode._

  val threads = table[Thread]("thread")
  val messages = table[Message]("message")
  val users = table[User]("users")

  val messageToThread = oneToManyRelation(messages, threads).via((m, t) => m.id === t.messageId)
  val userToMessage = oneToManyRelation(users, messages).via((u, m) => u.id === m.ownerId)
}
