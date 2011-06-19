package whitepaper.domain.squeryl

import whitepaper.infrastructure.clock.ClockComponent
import whitepaper.infrastructure.log.Logging
import whitepaper.domain._

trait SquerylThreadRepositoryComponent extends ThreadRepositoryComponent {
  self: ClockComponent =>

  class SquerylThreadRepository extends ThreadRepository with Logging {
    import whitepaper.domain.squeryl.AppSchema._
    import org.squeryl.PrimitiveTypeMode._

    def findAll() = inTransaction { from(threads)(t => select(t)).toList }
  }
}
