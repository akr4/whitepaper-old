package whitepaper.domain.squeryl

trait MessageRepositoryComponent {
  val messageRepository: MessageRepository

  trait MessageRepository {
    def save(message: Message)
  }

}