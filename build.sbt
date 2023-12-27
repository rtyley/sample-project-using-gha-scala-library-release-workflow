import ReleaseTransformations.*
import sbtversionpolicy.withsbtrelease.ReleaseVersion

ThisBuild / scalaVersion := "2.13.12"
ThisBuild / crossScalaVersions := Seq(
  scalaVersion.value,
  "3.3.1",
  "2.12.18"
)
ThisBuild / scalacOptions := Seq("-deprecation", "-release:11")

lazy val baseSettings = Seq(
  organization := "com.madgag.sample-gslrw",
  licenses := Seq(License.Apache2),
  libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.2.17" % Test
  ),
  Test / testOptions +=
    Tests.Argument(TestFrameworks.ScalaTest, "-u", s"test-results/scala-${scalaVersion.value}", "-o")
)

lazy val core = project.settings(baseSettings)

lazy val extra = project.dependsOn(core).settings(baseSettings)

lazy val `sample-gslrw-root` = (project in file("."))
  .aggregate(
    core,
    extra
  ).settings(
    publish / skip := true,
    releaseVersion := ReleaseVersion.fromAggregatedAssessedCompatibilityWithLatestRelease().value,
    releaseCrossBuild := true, // true if you cross-build the project for multiple Scala versions
    releaseProcess := Seq[ReleaseStep](
      checkSnapshotDependencies,
      inquireVersions,
      runClean,
      runTest,
      setReleaseVersion,
      commitReleaseVersion,
      tagRelease,
      setNextVersion,
      commitNextVersion
    )
  )
