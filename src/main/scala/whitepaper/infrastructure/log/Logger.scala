package whitepaper.infrastructure.log

import org.slf4j.LoggerFactory

class Logger[T](category: String) {

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
