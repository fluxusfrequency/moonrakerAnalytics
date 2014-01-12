import sbt._
class build(info: ProjectInfo) extends DefaultWebProject(info) {
// scalatra
val sonatypeNexusSnapshots = "Sonatype Nexus Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
val sonatypeNexusReleases = "Sonatype Nexus Releases" at "https://oss.sonatype.org/content/repositories/releases"

// jetty
val jetty6 = "org.mortbay.jetty" % "jetty" % "6.1.22" % "test"
val servletApi = "org.mortbay.jetty" % "servlet-api" % "2.5-20081211" % "provided"

//casbah
val casbah = "com.mongodb.casbah" %% "casbah" % "2.0.1"
}