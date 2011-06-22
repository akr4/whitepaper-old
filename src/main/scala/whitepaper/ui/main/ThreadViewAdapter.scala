package whitepaper.ui.main

import whitepaper.domain.squeryl.Thread
import org.joda.time.format.{ISODateTimeFormat, DateTimeFormatter, DateTimeFormat}

class ThreadViewAdapter(private val thread: Thread) {
  private val DATE_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd")

  def title = thread.title
  def body = thread.body
  def ownerName = thread.owner.name
  def createdAt = DATE_FORMAT.print(thread.createdAt)
  def createdAtIso8601 = thread.createdAt.toString()
  lazy val comments = thread.comments.map { c => new MessageViewAdapter(c) }
}
