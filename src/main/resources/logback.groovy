import static ch.qos.logback.classic.Level.*
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.classic.encoder.PatternLayoutEncoder

appender("STDOUT", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "%d %p %c{15} - %msg%n"
  }
}
root(INFO, [ "STDOUT" ])
logger("whitepaper", DEBUG, [ "STDOUT" ], false)
logger("ro.isdc.wro", DEBUG, [ "STDOUT" ], false)
logger("org.fusesource.scalate", DEBUG, [ "STDOUT" ], false)

