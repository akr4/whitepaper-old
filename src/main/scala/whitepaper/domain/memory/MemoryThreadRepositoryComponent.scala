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
        Thread("hello", Message(User("akira"), "Hello, World", clock.now)),
        Thread("おはよう", Message(User("andy"), "kon'nichiha", clock.now)),
        Thread("こんにちは", Message(User("andy"), "こんにちは。andy です", clock.now)),
        Thread("こんばんは", Message(User("akira"), "こんにちは。AKIRA です", clock.now))
      )
    }

  }
}
