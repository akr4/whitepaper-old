package whitepaper.domain

import java.util.UUID


case class EntityId(private val uuid: UUID) {
  private[domain] def simpleString(): String = uuid.toString
}

object EntityId {
  def newEntityId(): EntityId = new EntityId(UUID.randomUUID)
  def fromUuid(uuid: UUID): EntityId = new EntityId(uuid)
}

