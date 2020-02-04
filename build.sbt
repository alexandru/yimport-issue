import Dependencies._

ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "Yimport Issue",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.1.0"
    ),

    scalacOptions in Compile +=
      "-Yimports:java.lang,scala,scala.Predef,cats.implicits",
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
