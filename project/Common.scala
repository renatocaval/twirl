import sbt.Keys._
import sbt._
import sbt.plugins.JvmPlugin

import Dependencies._
import de.heikoseeberger.sbtheader.HeaderPlugin

object Common extends AutoPlugin {
  import HeaderPlugin.autoImport._

  override def trigger = noTrigger

  override def requires = JvmPlugin && HeaderPlugin

  val repoName = "twirl"

  val javacParameters = Seq(
    "-encoding",
    "UTF-8",
    "-Xlint:-options",
    "-source",
    "1.8",
    "-target",
    "1.8",
    "-Xlint:deprecation",
    "-Xlint:unchecked"
  )

  val scalacParameters = Seq(
    "-deprecation",
    "-feature",
    "-unchecked",
    "-encoding",
    "utf8",
    "-target:jvm-1.8",
    "-Ywarn-unused:imports",
    "-Xlint:nullary-unit",
    "-Xlint",
    "-Ywarn-dead-code",
  )

  val headerSettings =
    Seq(
      headerEmptyLine := false,
      headerLicense := Some(HeaderLicense.Custom("Copyright (C) Lightbend Inc. <https://www.lightbend.com>"))
    )

  override def globalSettings =
    Seq(
      organization := "com.typesafe.play",
      organizationName := "Lightbend Inc.",
      organizationHomepage := Some(url("https://www.lightbend.com/")),
      homepage := Some(url(s"https://github.com/playframework/${repoName}")),
      licenses := Seq("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.html")),
      scalaVersion := Scala212,
      crossScalaVersions := ScalaVersions,
      scalacOptions ++= scalacParameters,
      javacOptions ++= javacParameters,
      scmInfo := Some(
        ScmInfo(
          url(s"https://github.com/playframework/${repoName}"),
          s"scm:git:git@github.com:playframework/${repoName}.git"
        )
      ),
      developers += Developer(
        "contributors",
        "Contributors",
        "https://gitter.im/playframework/contributors",
        url("https://github.com/playframework")
      ),
      description := "Twirl"
    )

  override def projectSettings = headerSettings
}
