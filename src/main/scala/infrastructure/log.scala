package whitepaper.infrastructure.log

class Logger[T](category: String) {
  import org.slf4j.LoggerFactory

  private val logger = LoggerFactory.getLogger(category)

  def this(categoryClass: Class[T]) = this(categoryClass.getName)

  def trace(message: => AnyRef) {
    if (logger.isTraceEnabled) logger.trace(message.toString)
  }

  def debug(message: => AnyRef) {
    if (logger.isDebugEnabled) logger.debug(message.toString)
  }

  def info(message: => AnyRef) {
    if (logger.isInfoEnabled) logger.info(message.toString)
  }

  def warn(message: => AnyRef) {
    if (logger.isWarnEnabled) logger.warn(message.toString)
  }

  def error(message: => AnyRef) {
    if (logger.isErrorEnabled) logger.error(message.toString)
  }

}

trait Logging {

  private val logger = new Logger(getClass.getName)

  def trace(message: => AnyRef) { logger.trace(message) }
  def debug(message: => AnyRef) { logger.debug(message) }
  def info(message: => AnyRef) { logger.info(message) }
  def warn(message: => AnyRef) { logger.warn(message) }
  def error(message: => AnyRef) { logger.error(message) }

}

