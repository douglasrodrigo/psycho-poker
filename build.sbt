name := "psycho-poker"

version := "1.0"

scalaVersion := "2.10.2"

mainClass in (Compile, run) := Some("poker.PsychoPoker")

libraryDependencies ++= Seq(
    "org.specs2" %% "specs2" % "2.2.2" % "test"
)
