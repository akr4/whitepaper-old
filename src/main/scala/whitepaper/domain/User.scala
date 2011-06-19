package whitepaper.domain

import org.squeryl.KeyedEntity

class User(
  val id: Long,
  val name: String
) extends KeyedEntity[Long]