package whitepaper.domain


trait ThreadRepositoryComponent {
  val threadRepository: ThreadRepository

  trait ThreadRepository {
    def findAll(): List[Thread]
  }

}
