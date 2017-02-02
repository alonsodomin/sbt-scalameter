package scalameter

import sbt._
import Keys._

object ScalaMeterPlugin extends AutoPlugin {

  object autoImport extends ScalaMeterKeys {
    lazy val Benchmark = config("bench") extend Test
  }
  import autoImport._

  override def requires = plugins.JvmPlugin

  lazy val coreScalaMeterSettings = Seq(
    scalaMeterVersion := "0.8.2",
    libraryDependencies += "com.storm-enroute" %% "scalameter" % scalaMeterVersion.value % Benchmark
  )

  lazy val baseScalaMeterSettings = Defaults.testSettings ++ Seq(
    parallelExecution := false,
    testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework"),
    scalaSource := baseDirectory.value / "src" / "bench" / "scala"
  )

  override lazy val projectConfigurations = Seq(Benchmark)

  override lazy val projectSettings = coreScalaMeterSettings ++ inConfig(Benchmark)(baseScalaMeterSettings)

}
