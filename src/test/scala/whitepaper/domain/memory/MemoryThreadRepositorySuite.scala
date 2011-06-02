package whitepaper.domain.memory

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import whitepaper.infrastructure.MutableClockComponent
import org.joda.time.DateTime


class MemoryThreadRepositorySuite extends FunSuite with ShouldMatchers
  with MemoryThreadRepositoryComponent
  with MutableClockComponent {

  val threadRepository = new MemoryThreadRepository
  val clock = new MutableClock

  test("MemoryThreadRepositorySuite uses Clock to get current time") {
    clock.now = new DateTime(2011, 1, 1, 0, 0, 0, 0)

    val threads = threadRepository.findAll

    assert(threads.size == 4)
    assert(threads(0).createdAt == new DateTime(2011, 1, 1, 0, 0, 0, 0))
  }
}