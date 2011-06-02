package whitepaper.ui.main

import javax.servlet.ServletContext


trait ServletContextSupplier {
  def servletContext: ServletContext
}