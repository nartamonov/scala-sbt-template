lazy val $name;format="camel"$ = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "$name;format="normalize"$",

    fork := true,

    libraryDependencies ++= Seq(
      "com.lihaoyi" %% "pprint" % "0.5.1",
      "org.scalactic" %% "scalactic" % "3.0.2",
      "org.scalatest" %% "scalatest" % "3.0.2" % "test"
    )
  )

lazy val commonSettings = Seq(
  version               := "0.1",
  startYear             := Some(2017),
  scalaVersion          := "$scala_version$",
  scalacOptions         ++= Seq("-target:jvm-1.8", "-deprecation", "-unchecked", "-Xcheckinit", "-encoding", "utf8", "-feature"),
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
