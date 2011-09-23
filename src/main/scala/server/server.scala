package whitepaper

object MyApp extends App {
  unfiltered.jetty.Http(8080).filter(new whitepaper.ui.main.MainPlan).run()
}
