package whitepaper.domain.squeryl

import whitepaper.infrastructure.log.Logging

trait SquerylMessageRepositoryComponent extends MessageRepositoryComponent {

  class SquerylMessageRepository extends MessageRepository with Logging {
    import whitepaper.domain.squeryl.BbsDb._
    import org.squeryl.PrimitiveTypeMode._

    def save(message: Message) {
      inTransaction {
        messages.update(message)
      }
    }
  }
}