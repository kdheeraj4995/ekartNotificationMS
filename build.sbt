name := """notification"""
organization := "com.dheeraj"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava).disablePlugins(PlayFilters)

PlayKeys.devSettings := Seq("play.server.http.port" -> "9002")


scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  guice,
  "org.apache.commons" % "commons-email" % "1.5",
  "com.dheeraj" % "security" % "0.0.1-SNAPSHOT",
  "com.dheeraj" % "utility" % "0.0.1-SNAPSHOT"
)

resolvers += Resolver.mavenLocal
