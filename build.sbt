version in ThisBuild := "1.0-SNAPSHOT"

organization in ThisBuild := "com.accenture"

scalaVersion in ThisBuild := "2.12.1"

licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html"))


addCommandAlias("test-common", ";project bda-core-common ;test ;project /")

addCommandAlias("test-complete", ";project bda-core-complete ;test ;project /")

addCommandAlias("test-all", ";test-common ; test-complete ;project /")

addCommandAlias("scoverage-common", ";project bda-core-common ;scoverage:test ;project /")

addCommandAlias("scoverage-complete", ";project bda-core-complete ;scoverage:test ;project /")

addCommandAlias("scoverage-all", ";scoverage-common ;scoverage-complete ;project /")

addCommandAlias("sanity", ";clean ;compile ;scalastyle ;scoverage-all ;assembly")

addCommandAlias("sanity-no-clean", ";compile ;scalastyle ;scoverage-all ;assembly")

javaOptions in (Test,run) += "-Xms512m -Xmx2g -Xss256M -XX:MaxPermSize=2048m -XX:+CMSClassUnloadingEnabled -XX:ReservedCodeCacheSize=512m"

libraryDependencies in ThisBuild ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.1",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

pomExtra :=
  <url>https://github.com/snafis/scala-school</url>
  <scm>
      <url>git@github.com:snafis/scala-school.git</url>
      <connection>scm:git:git@github.com:snafis/scala-school.git</connection>
  </scm>
  <developers>
      <developer>
          <id>snafis</id>
          <name>Shifath Nafis</name>
          <url>https://github.com/snafis</url>
      </developer>
  </developers>

        