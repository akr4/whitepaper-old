package whitepaper.domain

class User(
  val id: EntityId,
  val name: String
) extends Entity {
}

object User {
  def apply(name: String): User = new User(EntityId.newEntityId, name)
}