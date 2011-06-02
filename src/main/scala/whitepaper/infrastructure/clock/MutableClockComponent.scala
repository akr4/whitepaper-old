package whitepaper.infrastructure.clock

import org.joda.time.DateTime

trait MutableClockComponent extends ClockComponent {

  class MutableClock extends Clock {
    private var _now: Option[DateTime] = None

    def now = _now match {
      case Some(now) => now
      case None => new DateTime
    }

    def now_=(now: DateTime) {
      _now = Some(now)
    }

    def today = now.toLocalDate

  }

}
