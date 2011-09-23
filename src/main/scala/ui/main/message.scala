package whitepaper.ui.main

import whitepaper.domain.Message

class MessageViewAdapter(private val message: Message) {
  import org.joda.time.format.DateTimeFormat
  import org.joda.time.DateTime

  private val DATE_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd")

  def body = message.body
  def ownerName = message.owner.name
  def createdAt = DATE_FORMAT.print(new DateTime)
  def createdAtIso8601 = createdAt.toString()

}

