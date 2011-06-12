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
        Thread("hello", Message(User("user1"), "Hello, World", clock.now)),
        Thread("おはよう", Message(User("user1"), "kon'nichiha", clock.now)),
        Thread("こんにちは", Message(User("user2"), "こんにちは", clock.now)),
        Thread("こんばんは", Message(User("user2"), "こんばんは", clock.now))
      )
    }

  }
}
