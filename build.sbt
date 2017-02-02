
lazy val artifactSettings = Seq(
  name := "sbt-scalameter",
  organization := "com.github.alonsodomin",
  description := "SBT plugin for running ScalaMeter benchmarks"
)

lazy val pluginSettings = Seq(
  sbtPlugin := true,
  scalaVersion in ThisBuild := "2.10.6"
)

lazy val pluginTestSettings = ScriptedPlugin.scriptedSettings ++ Seq(
  scriptedLaunchOpts ++= Seq(
    "-Xmx1024M",
    "-XX:MaxPermSize=256M",
    "-Dplugin.version=" + version.value,
    "-Dsbttest.base=" + (sourceDirectory.value / "sbt-test").getAbsolutePath
  ),
  scriptedBufferLog := false
)

lazy val allSettings =
  artifactSettings ++
  pluginSettings ++
  pluginTestSettings

lazy val `sbt-scalameter` = (project in file("."))
  .settings(allSettings)
  .settings(
    moduleName := "sbt-scalameter"
  )
