lazy val sampleProject = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "sample-project",

    fork := true,

    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % "2.4.1"
    )
  )

lazy val commonSettings = Seq(
  version               := "0.1",
  startYear             := Some(2016),
  scalaVersion          := "2.11.7",
  scalacOptions         ++= Seq("-target:jvm-1.7", "-deprecation", "-unchecked", "-Xcheckinit", "-encoding", "utf8", "-feature"),
  scalacOptions         ++= Seq(
    "-language:implicitConversions",
    "-language:postfixOps",
    "-language:reflectiveCalls",
    "-language:higherKinds"
  ),

  // configure prompt to show current project
  shellPrompt           := { s => Project.extract(s).currentProject.id + " > " },

  initialCommands in console :=
    """
      |import java.nio.file._
      |import scala.concurrent._
      |import scala.concurrent.duration._
      |import ExecutionContext.Implicits.global
    """.stripMargin
)
