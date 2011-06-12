import sbt._

class MyProject(info: ProjectInfo) extends DefaultWebProject(info) with IdeaProject {
  val scalatraVersion = "2.0.0-SNAPSHOT"

  override def scanDirectories = Nil

  val sonatypeNexusSnapshots = "Sonatype Nexus Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  // For Scalate
  val fuseSourceSnapshots = "FuseSource Snapshot Repository" at "http://repo.fusesource.com/nexus/content/repositories/snapshots"

  val scalatra = "org.scalatra" %% "scalatra" % scalatraVersion withSources()
  val auth = "org.scalatra" %% "scalatra-auth" % scalatraVersion withSources()
  val scalate = "org.scalatra" %% "scalatra-scalate" % scalatraVersion withSources()
  val servletApi = "org.mortbay.jetty" % "servlet-api" % "2.5-20081211" % "provided" withSources()

  // Alternatively, you could use scalatra-specs
  val scalatest = "org.scalatra" %% "scalatra-scalatest" % scalatraVersion % "test" withSources()

  // Pick your favorite slf4j binding
  val slf4jBinding = "ch.qos.logback" % "logback-classic" % "0.9.25" % "runtime" withSources()

  // http://groups.google.com/group/simple-build-tool/msg/1f17b43807d06cda
  override def testClasspath = super.testClasspath +++ buildCompilerJar

  val jodaTime = "joda-time" % "joda-time" % "1.6.2" withSources()

//  val casbah = "com.mongodb.casbah" % "casbah_2.8.1" % "2.0.2" withSources()
  val jacksonMapperAsl = "org.codehaus.jackson" % "jackson-mapper-asl" % "1.8.0" withSources()

  val wro4j = "ro.isdc.wro4j" % "wro4j-core" % "1.3.6" withSources()
  val wro4jExtensions = "ro.isdc.wro4j" % "wro4j-extensions" % "1.3.6" withSources()

  val commonsEmail = "commons-email" % "commons-email" % "1.1"
}
