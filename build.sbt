name := "scalim"

organization in ThisBuild := "org.auroboros"
version in ThisBuild := "0.0.1-SNAPSHOT"

homepage in ThisBuild := Some(url("https://github.com/auroboros/scalim"))
licenses in ThisBuild := Seq("copyright" -> url("https://github.com/auroboros/scalim/blob/master/license.txt"))

pomExtra in ThisBuild := (<scm>
  <url>git@github.com:auroboros/scalim.git</url>
  <connection>scm:git:git@github.com:auroboros/scalim.git</connection>
</scm>
  <developers>
    <developer>
      <id>fat0wl</id>
      <name>John McGill</name>
      <url>https://github.com/auroboros</url>
    </developer>
  </developers>)

scalaVersion in ThisBuild := "2.11.8"

publishMavenStyle in ThisBuild := true

publishTo in ThisBuild := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

resolvers in ThisBuild += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies in ThisBuild ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.scalaz" %% "scalaz-core" % "7.2.8" % "test"
)

fork in run := true

lazy val root = project.in(file("."))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings: _*)
  .settings(publishArtifact := false)
  .aggregate(scalimCore)

lazy val scalimCore = project.in(file("scalim-core"))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings: _*)