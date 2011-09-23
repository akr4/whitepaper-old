package whitepaper.domain

trait ThreadRepositoryComponent {
  val threadRepository: ThreadRepository

  trait ThreadRepository {
    def find(id: Long): Option[Thread]

    def findAll(): List[Thread]
  }

}

trait MessageRepositoryComponent {
  val messageRepository: MessageRepository

  trait MessageRepository {
    def save(message: Message)
  }

}
