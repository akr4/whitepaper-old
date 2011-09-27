name := "whitepaper"

version := "1.0"

organization := "physalis.net"

scalaVersion := "2.9.1"

resolvers ++= Seq(
  ScalaToolsSnapshots,
  "Sonatype Nexus Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  "FuseSource Snapshot Repository" at "http://repo.fusesource.com/nexus/content/repositories/snapshots"
)

seq(webSettings :_*)

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "1.6.2" withSources(),
  "org.scala-tools.time" %% "time" % "0.5",
  "commons-email" % "commons-email" % "1.1",
  "org.fusesource.scalate" % "scalate-wikitext" % "1.5.2",
  "org.fusesource.scalate" % "scalate-page" % "1.5.2",
//  "net.liftweb" %% "lift-json" % "2.4-M3",
  // Logging
  "ch.qos.logback" % "logback-classic" % "0.9.25" withSources(),
  "org.codehaus.groovy" % "groovy" % "1.8.0" withSources(),
  "org.slf4j" % "jcl-over-slf4j" % "1.6.2" withSources(),
  "org.clapper" %% "grizzled-slf4j" % "0.6.6",
  // Unfiltered
  "net.databinder" %% "unfiltered-filter" % "0.5.0" withSources(),
  "net.databinder" %% "unfiltered-jetty" % "0.5.0" withSources(),
  "net.databinder" %% "unfiltered-scalate" % "0.5.0" withSources(),
  // WRO4J
  "ro.isdc.wro4j" % "wro4j-core" % "1.4.1",
  "ro.isdc.wro4j" % "wro4j-extensions" % "1.4.1",
  "org.eclipse.jetty" % "jetty-webapp" % "7.3.0.v20110203" % "jetty"
)

// jetty
jettyContext := "/whitepaper"