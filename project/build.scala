import sbt._
import android.Keys._
import Keys._


object Build extends android.AutoBuild {

  import Dependencies._

  val resolvers = Seq(
    "Maven central" at "http://oss.sonatype.org/content/repositories/releases",
    "Typesafe releases" at "http://repo.typesafe.com/typesafe/releases/"   
  )

  val buildSettings = android.Plugin.androidBuild ++
    Seq(libraryDependencies ++= Akka ++ Spray ++ Scaloid,
	      externalResolvers := Resolver.withDefaultResolvers(resolvers),
	      proguardOptions in Android ++= Seq("@project/proguard.cfg"),
	      useProguard in Android := true,
	      apkbuildExcludes in Android ++= Seq("reference.conf")
    )

  val main = Project(
    "AndroidAkkaSprayExample",
    file("."),
    settings = buildSettings)


}



object Dependencies {

  import Versions._

  val Akka = Seq(
    "com.typesafe.akka" %% "akka-actor" % AkkaVersion,
    "com.typesafe" % "config" % "1.0.2"
  )

  val Spray = Seq(
    "io.spray" % "spray-client" % SprayVersion,
    "io.spray" %% "spray-json" % SprayJsonVersion,
    "io.spray" % "spray-can" % SprayVersion
  )

  val Scaloid = Seq(
    "org.scaloid" %% "scaloid" % ScaloidVersion
  )	


  object Versions {
    val SprayVersion = "1.3.1"
    val AkkaVersion = "2.3.3"
    val ScaloidVersion = "3.3-8"
    val SprayJsonVersion = "1.2.6"
  }

}




