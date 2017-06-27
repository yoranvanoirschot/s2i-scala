name := """test-app"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala, Jolokia)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)
libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.1.1" % "provided"
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.1.1" % "provided"