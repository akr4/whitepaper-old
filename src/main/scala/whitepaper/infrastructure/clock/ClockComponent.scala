package whitepaper.infrastructure.clock

import org.joda.time.{LocalDate, DateTime}

trait ClockComponent {
  val clock: Clock

  trait Clock {
    def now: DateTime

    def today: LocalDate
  }

}
