package whitepaper.domain.squeryl

trait ThreadRepositoryComponent {
  val threadRepository: ThreadRepository

  trait ThreadRepository {
    def find(id: Long): Option[Thread]

    def findAll(): List[Thread]
  }

}
