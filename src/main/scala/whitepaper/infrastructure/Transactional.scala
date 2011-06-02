package whitepaper.infrastructure

import log.Logger

trait Transactional {

  def withTransaction[T](f: => T) {
    try {
      val ret = f
    } catch {
      case t: Throwable => throw t
    }
  }
}
