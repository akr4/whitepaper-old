package whitepaper.ui.main

import org.scalatra.scalate.ScalateSupport
import javax.servlet.ServletContext


trait Controller extends ScalateSupport {
  self: { def servletContext: ServletContext } =>

  def render(viewName: String, values: Map[String, Any]): String = {
    templateEngine.layout(templatePath(viewName), values)
  }

  private def templatePath(name: String): String = {
    "/WEB-INF/scalate/templates/" + name + ".ssp"
  }
}
