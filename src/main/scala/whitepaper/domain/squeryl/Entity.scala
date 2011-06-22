package whitepaper.domain.squeryl

import org.squeryl.KeyedEntity

trait Entity extends KeyedEntity[Long] {
  val id: Long = 0

  override def toString: String = {
    "%s(%d)".format(getClass.getName, id)
  }

}
