name := """rj_play_cucumber"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "info.cukes" % "cucumber-scala_2.11" % "1.2.4"
)
//addSbtPlugin("templemore" % "sbt-cucumber-plugin" % "0.8.0")

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
resolvers += "Templemore Repository" at "http://templemore.co.uk/repo"


// play cumcmber integration
cucumberSettings

cucumberFeaturesLocation := "./test/features"

cucumberStepsBasePackage := "features.steps"
