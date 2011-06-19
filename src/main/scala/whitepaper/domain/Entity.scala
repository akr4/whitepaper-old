package whitepaper.domain

import org.squeryl.KeyedEntity

trait Entity extends KeyedEntity[Long] {
  val id: Long

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
    "%s(%d)".format(getClass.getName, id)
  }

}
