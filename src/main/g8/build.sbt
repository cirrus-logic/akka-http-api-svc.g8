import sbt._
import sbt.Keys._

lazy val akkaHttpVersion = "10.1.0"
lazy val akkaVersion    = "2.5.11"
lazy val catsV         = "1.0.1"
lazy val circeV        = "0.9.2"
lazy val ficusV        = "1.4.1"
lazy val akkaCirceV    = "1.20.+"
lazy val paradiseV     = "2.1.0"
lazy val scalaTestV = "3.0.1"

lazy val root = (project in file(".")).
  configs(IntegrationTest).
  settings(
    inThisBuild(List(
      organization    := "$organization$",
      scalaVersion    := "$scalaVersion$"
    )),
    name := "$name;format="norm"$",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % akkaVersion,
      "com.typesafe.akka" %% "akka-stream" % akkaVersion,
      "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
      "com.github.etaty"  %% "rediscala" % "1.8.0",
      "com.iheart" %% "ficus" % ficusV,
      "org.typelevel" %% "cats-core" % catsV,
      "io.circe" %% "circe-core" % circeV,
      "io.circe" %% "circe-generic" % circeV,
      "io.circe" %% "circe-parser" % circeV,
      "de.heikoseeberger" %% "akka-http-circe" % akkaCirceV,
      "com.github.t3hnar" %% "scala-bcrypt" % "3.0",
      "com.github.nscala-time" %% "nscala-time" % "2.16.0",

      "com.typesafe.akka" %% "akka-http-testkit"    % akkaHttpVersion % Test,
      "com.typesafe.akka" %% "akka-testkit"         % akkaVersion     % Test,
      "com.typesafe.akka" %% "akka-stream-testkit"  % akkaVersion     % Test,
      "org.scalatest"     %% "scalatest"            % scalaTestV         % Test
    ),
    scalacOptions += "-Ypartial-unification",
    autoCompilerPlugins := true,
    addCompilerPlugin("org.scalamacros" % "paradise" % paradiseV cross CrossVersion.full),
    unmanagedSourceDirectories in IntegrationTest += baseDirectory.value / "src/test-helpers/scala",
    unmanagedSourceDirectories in Test += baseDirectory.value / "src/test-helpers/scala"
  )
