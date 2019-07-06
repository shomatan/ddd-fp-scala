name := "ddd-fp-scala"

lazy val commonSettings = Seq(
  version := "0.1.0",
  scalaVersion := "2.12.8",
  javacOptions ++= Seq("-encoding", "UTF-8"),
  test in assembly := {},
  libraryDependencies ++= {
    val catsVersion = "2.0.0-M4"
    val monixVersion = "3.0.0-RC3"
    Seq(
      "org.typelevel" %% "cats-core"      % catsVersion,
      "org.typelevel" %% "cats-kernel"    % catsVersion,
      "org.typelevel" %% "cats-macros"    % catsVersion,
      "io.monix"      %% "monix"          % monixVersion,
      "io.monix"      %% "monix-eval"     % monixVersion,
      "io.monix"      %% "monix-reactive" % monixVersion,
      "com.chuusai"   %% "shapeless"      % "2.3.3",
      // Test
      "org.scalatest" %% "scalatest" % "3.0.8" % "test"
    )
  }
)

lazy val shared = (project in file("modules/shared"))
  .settings(commonSettings)

lazy val `user-domain` = (project in file("modules/user/domain"))
  .settings(commonSettings)
  .dependsOn(shared)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(
    assemblyJarName in assembly := {
      s"${name.value}.jar"
    }
  )
  .dependsOn(shared)
