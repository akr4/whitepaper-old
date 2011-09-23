package whitepaper.domain

import whitepaper.infrastructure.clock.ClockComponent
import whitepaper.infrastructure.log.Logging

trait DummyThreadRepositoryComponent extends ThreadRepositoryComponent {
  self: ClockComponent =>

  class DummyThreadRepository extends ThreadRepository with Logging {
    def find(id: Long) = None
    def findAll() = List(new Thread("test1"), new Thread("test2"), new Thread("test3"))
  }
}

trait DummyMessageRepositoryComponent extends MessageRepositoryComponent {

  class DummyMessageRepository extends MessageRepository with Logging {
    def save(message: Message) {
    }
  }
}
