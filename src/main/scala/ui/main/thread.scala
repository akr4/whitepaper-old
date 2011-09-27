package whitepaper.ui.main

import unfiltered.request._
import unfiltered.response._
import unfiltered.filter.Plan
import unfiltered.filter.Plan.Intent
import unfiltered.filter.request.ContextPath
import whitepaper.domain.Thread
import whitepaper.domain.Message
import whitepaper.domain.User
import whitepaper.domain.ThreadRepositoryComponent
import whitepaper.domain.MessageRepositoryComponent
import whitepaper.infrastructure.mail.MailSenderComponent
import whitepaper.infrastructure.log.Logging

class ThreadViewAdapter(private val thread: Thread) {
  import org.joda.time.format.{ISODateTimeFormat, DateTimeFormatter, DateTimeFormat}

  private val DATE_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd")

  def title = thread.title
  def body = thread.body
  def ownerName = thread.owner.name
  def createdAt = DATE_FORMAT.print(thread.createdAt)
  def createdAtIso8601 = thread.createdAt.toString()
  lazy val comments = thread.comments.map { c => new MessageViewAdapter(c) }
  def viewCount = thread.firstMessage.viewCount

  def detailUrl() = "/threads/" + 1 // thread.id
}

trait ThreadController {
  self: ThreadRepositoryComponent
    with MessageRepositoryComponent
    with MailSenderComponent
    with Logging
  =>

  def threadController(
    engine: org.fusesource.scalate.TemplateEngine,
    config: javax.servlet.FilterConfig
  ): Intent = {
    case req @ ContextPath(ctx, Seg("threads" :: Nil)) =>
      debug(ctx)
      Ok ~> HtmlContent ~> Scalate(engine, config, req, "threads.ssp",
	      ("threads" -> threadRepository.findAll().map { t => new ThreadViewAdapter(t) }))
    case req @ ContextPath(_, Seg("threads" :: id :: Nil)) =>
      threadRepository.find(id.toInt) match {
	case Some(t) =>
	  t.firstMessage.viewed(new User("user1"))
	  messageRepository.save(t.firstMessage)
	  Ok ~> HtmlContent ~> Scalate(engine, config, req, "thread.ssp",
	          ("thread" -> new ThreadViewAdapter(t))
		)
        case None => NotFound
      }
  } 
}
