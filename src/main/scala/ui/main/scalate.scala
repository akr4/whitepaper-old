package whitepaper.ui.main

import org.fusesource.scalate.TemplateEngine
import org.fusesource.scalate.servlet.ServletRenderContext
import unfiltered.request._
import unfiltered.response._
import unfiltered.scalate.{ Scalate => UFS }
import java.io.OutputStreamWriter
import java.io.PrintWriter
import javax.servlet.FilterConfig
import javax.servlet.http.{ HttpServletRequest, HttpServletResponse }
import grizzled.slf4j.Logging

class Scalate(engine: TemplateEngine, config: FilterConfig, req: HttpRequest[HttpServletRequest], template: String, attributes: (String, Any)*)
  extends Responder[HttpServletResponse] with Logging {
  override def respond(res: HttpResponse[HttpServletResponse]) {
    val writer = res.outputStream
    // todo: close, error handling
    try {
      val context = new ServletRenderContext(engine, new PrintWriter(writer), req.underlying, res.underlying, config.getServletContext)
      debug("aaa")
      UFS(req, template, attributes: _*)(engine, { (_, _, _) => context })
      debug("bbb")
    } finally {
      writer.close
    }
  }
}
object Scalate {
  def apply[A, B](engine: TemplateEngine, config: FilterConfig, req: HttpRequest[HttpServletRequest], template: String, attributes: (String, Any)*): Scalate = {
    new Scalate(engine, config, req, template, attributes: _*)
  }
}
