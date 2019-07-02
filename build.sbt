name := "ddd-fp-scala"

lazy val commonSettings = Seq(
  version := "0.1.0",
  scalaVersion := "2.12.8",
  javacOptions ++= Seq("-encoding", "UTF-8"),
  test in assembly := {}
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(
    libraryDependencies ++= {
    val catsVersion = "2.0.0-M4"
    val monixVersion = "3.0.0-RC3"
    Seq(
      "org.typelevel" %% "cats-core"      % catsVersion,
      "org.typelevel" %% "cats-kernel"    % catsVersion,
      "org.typelevel" %% "cats-macros"    % catsVersion,
      "org.typelevel" %% "cats-free"      % catsVersion,
      "io.monix"      %% "monix"          % monixVersion,
      "io.monix"      %% "monix-eval"     % monixVersion,
      "io.monix"      %% "monix-reactive" % monixVersion,
      "com.chuusai"   %% "shapeless"      % "2.3.3",
      "org.scalatest" %% "scalatest"      % "3.0.8"       % "test"
    )
  },
  assemblyJarName in assembly := {
    s"${name.value}.jar"
  } 
)