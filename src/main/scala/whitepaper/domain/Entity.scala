package whitepaper.domain

trait Entity {
  val id: EntityId

  override def equals(o: Any): Boolean = {
    o match {
      case o: Entity => id == o.id
      case _ => false
    }
  }

  override def hashCode(): Int = {
    id.hashCode
  }

  override def toString: String = {
    format("%s(%d)", getClass.getName, id.simpleString)
  }

}
