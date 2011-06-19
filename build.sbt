name := "whitepaper"

version := "1.0"

organization := "physalis.net"

scalaVersion := "2.9.0-1"

resolvers += "Sonatype Nexus Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

resolvers += "FuseSource Snapshot Repository" at "http://repo.fusesource.com/nexus/content/repositories/snapshots"

seq(WebPlugin.webSettings :_*)

libraryDependencies ++= Seq(
  "org.mortbay.jetty" % "jetty" % "6.1.22" % "jetty",
  "javax.servlet" % "servlet-api" % "2.5" % "provided",
  "org.scalatra" %% "scalatra" % "2.0.0-SNAPSHOT",
  "org.scalatra" %% "scalatra-scalate" % "2.0.0-SNAPSHOT",
  "org.scalatra" %% "scalatra-scalatest" % "2.0.0-SNAPSHOT" % "test",
  "ch.qos.logback" % "logback-classic" % "0.9.25",
  "joda-time" % "joda-time" % "1.6.2",
  "org.codehaus.jackson" % "jackson-mapper-asl" % "1.8.0",
  "ro.isdc.wro4j" % "wro4j-core" % "1.3.6",
  "ro.isdc.wro4j" % "wro4j-extensions" % "1.3.6",
  "commons-email" % "commons-email" % "1.1"
)
