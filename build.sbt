name := """notification"""
organization := "com.dheeraj"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  guice,
  "com.dheeraj" % "security" % "0.0.1-SNAPSHOT",
  "com.dheeraj" % "utility" % "0.0.1-SNAPSHOT"
)

resolvers += Resolver.mavenLocal
