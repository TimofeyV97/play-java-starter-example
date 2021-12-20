lazy val root = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)
  .settings(
    name := """play-java-starter-example""",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.6",
    playEnhancerEnabled := false,
    libraryDependencies ++= Seq(
      javaJdbc,
      "mysql" % "mysql-connector-java" % "5.1.47",
      guice,
      "org.projectlombok" % "lombok" % "1.18.10" % Provided,
      "org.assertj" % "assertj-core" % "3.14.0" % Test,
      "org.awaitility" % "awaitility" % "4.0.1" % Test,
      "org.jsoup" % "jsoup" % "1.8.3",
      "org.apache.commons" % "commons-text" % "1.9"
    ),
    javacOptions ++= Seq(
      "-encoding", "UTF-8",
      "-parameters",
      "-Xlint:unchecked",
      "-Xlint:deprecation",
      "-Werror"
    ),
  )
