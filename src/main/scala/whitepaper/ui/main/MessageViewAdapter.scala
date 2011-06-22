package whitepaper.ui.main

import org.joda.time.format.DateTimeFormat
import whitepaper.domain.squeryl.Message
import org.joda.time.DateTime

class MessageViewAdapter(private val message: Message) {
  private val DATE_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd")

  def body = message.body
  def ownerName = message.owner.name
  def createdAt = DATE_FORMAT.print(new DateTime)
  def createdAtIso8601 = createdAt.toString()

}