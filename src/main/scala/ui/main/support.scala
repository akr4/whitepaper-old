package whitepaper.ui.main

object ViewSupport {
  import org.fusesource.scalate.servlet.ServletRenderContext._

  // TODO: won't work. 
  // java.lang.IllegalArgumentException: This threads RenderContext is not a ServletRenderContext as it is: org.fusesource.scalate.DefaultRenderContext@178bf083
  def url(s: String): String = {
    request.getContextPath + s
  }
}
