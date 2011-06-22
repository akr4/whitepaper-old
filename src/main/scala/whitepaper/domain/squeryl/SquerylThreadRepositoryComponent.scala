package whitepaper.domain.squeryl

import whitepaper.infrastructure.clock.ClockComponent
import whitepaper.infrastructure.log.Logging

trait SquerylThreadRepositoryComponent extends ThreadRepositoryComponent {
  self: ClockComponent =>

  class SquerylThreadRepository extends ThreadRepository with Logging {
    import whitepaper.domain.squeryl.BbsDb._
    import org.squeryl.PrimitiveTypeMode._

    def find(id: Long) = inTransaction { threads.lookup(id) }
    def findAll() = inTransaction { from(threads)(t => select(t)).toList }
  }
}
