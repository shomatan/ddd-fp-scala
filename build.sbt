name := "ddd-fp-scala"

version := "0.1.0"

scalaVersion := "2.12.8"

val catsVersion = "2.0.0-M4"
val monixVersion = "3.0.0-RC3"

libraryDependencies ++= Seq(
  "io.spray"      %% "spray-json"     % "1.3.5",
  "org.typelevel" %% "cats-core"      % catsVersion,
  "org.typelevel" %% "cats-kernel"    % catsVersion,
  "org.typelevel" %% "cats-macros"    % catsVersion,
  "org.typelevel" %% "cats-free"      % catsVersion,
  "io.monix"      %% "monix"          % monixVersion,
  "io.monix"      %% "monix-eval"     % monixVersion,
  "io.monix"      %% "monix-reactive" % monixVersion,

  "org.scalatest" %% "scalatest" % "3.0.8" % "test"
)

