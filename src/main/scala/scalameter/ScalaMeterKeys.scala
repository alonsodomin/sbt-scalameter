package scalameter

import sbt._

trait ScalaMeterKeys {
  lazy val scalaMeterVersion = settingKey[String]("ScalaMeter version")
}

object ScalaMeterKeys extends ScalaMeterKeys
