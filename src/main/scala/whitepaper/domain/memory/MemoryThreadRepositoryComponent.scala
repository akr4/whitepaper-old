package whitepaper.domain.memory

import whitepaper.domain._
import whitepaper.infrastructure.clock.ClockComponent
import whitepaper.infrastructure.log.Logging

trait MemoryThreadRepositoryComponent extends ThreadRepositoryComponent {
  self: ClockComponent =>

  class MemoryThreadRepository extends ThreadRepository with Logging {

    def findAll() = {
      debug("findAll")
      List(
        new Thread(1, "hello1", 1),
        new Thread(2, "hello2", 2),
        new Thread(3, "hello3", 3)
      )
    }

  }
}
