import sbt.Keys.libraryDependencies
import sbt._

object Dependencies {

  val Scala212      = "2.12.10"
  val Scala213      = "2.13.2"
  val ScalaVersions = Seq(Scala212, Scala213)

  val PlayVersion = sys.props.getOrElse("play.version", sys.env.getOrElse("PLAY_VERSION", "2.8.0"))

}
