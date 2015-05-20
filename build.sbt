name := "scala-react"

organization := "github.com.ingoem"

version := "1.0"

scalaVersion := "2.11.6"

crossScalaVersions := Seq("2.10.5", "2.11.6")

autoCompilerPlugins := true

scalacOptions ++= Seq(
	"-deprecation",
	"-unchecked",
	"-P:continuations:enable"
)

libraryDependencies ++= Seq(
	"org.scalatest" %% "scalatest" % "2.2.5" % "test",
	"junit" % "junit" % "4.11" % "test"
)

libraryDependencies <++= (scalaVersion) { (ver) =>
	if (ver.matches("2.11.\\d+")) {
		List(
			compilerPlugin("org.scala-lang.plugins" % "scala-continuations-plugin_2.11.2" % "1.0.2"),
			"org.scala-lang.plugins" %% "scala-continuations-library" % "1.0.2")
	}
	else {
		List(compilerPlugin("org.scala-lang.plugins" % "continuations" % ver))
	}
}
