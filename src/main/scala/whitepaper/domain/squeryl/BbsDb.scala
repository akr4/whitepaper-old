package whitepaper.domain.squeryl

import org.squeryl.Schema

object BbsDb extends Schema {

  import org.squeryl.PrimitiveTypeMode._

  val threads = table[Thread]("thread")
  val messages = table[Message]("message")
  val users = table[User]("users")

  val threadToMessages = oneToManyRelation(threads, messages).via((t, m) => t.id === m.threadId)
  val userToMessage = oneToManyRelation(users, messages).via((u, m) => u.id === m.ownerId)

  override def columnNameFromPropertyName(n:String) = camelCaseToUnderScoe(n)
  override def tableNameFromClassName(n:String) = camelCaseToUnderScoe(n)

  private def camelCaseToUnderScoe(s: String) =
    s.toList.map(c => if (c.isUpper) "_" + c.toLower else c).mkString
}
