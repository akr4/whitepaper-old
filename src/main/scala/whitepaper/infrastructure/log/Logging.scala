package whitepaper.infrastructure.log

trait Logging {

  private val logger = new Logger(getClass.getName)

  def trace(message: => AnyRef) { logger.trace(message) }
  def debug(message: => AnyRef) { logger.debug(message) }
  def info(message: => AnyRef) { logger.info(message) }
  def warn(message: => AnyRef) { logger.warn(message) }
  def error(message: => AnyRef) { logger.error(message) }

}
