package whitepaper.infrastructure

trait Transactional {

  def withTransaction[T](f: => T) {
    try {
      f
    } catch {
      case t: Throwable => throw t
    }
  }
}
