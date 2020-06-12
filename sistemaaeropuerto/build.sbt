import Dependencies._

ThisBuild / scalaVersion     := "2.13.2"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "sistemaAeropuerto",
    libraryDependencies += scalaTest % Test,
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % "2.5.25",
      "com.typesafe.akka" %% "akka-stream" % "2.5.25",
      "com.typesafe.akka" %% "akka-http" % "10.1.9",
      "com.typesafe.play" %% "play-json" % "2.8.1",
      "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.9"
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
