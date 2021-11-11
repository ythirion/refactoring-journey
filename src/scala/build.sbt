lazy val root = project.in(file("."))
  .settings(
    // set the name of the project
    name := "refactoring-journey",
    version := "0.1",
    scalaVersion := "2.13.6",
    // add dependencies
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.scalactic" %% "scalactic" % "3.2.9" % Test,
      "org.scalamock" %% "scalamock" % "5.1.0" % Test,
      "com.github.javafaker" % "javafaker" % "1.0.2",
    )
  )