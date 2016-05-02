name := "smile-shell"

// Parent project disables Scala as most libraries are in Java.
// Enable it as this is a Scala project.
crossPaths := true

autoScalaLibrary := true

mainClass in Compile := Some("smile.shell.Main")

// SBT native packager
enablePlugins(JavaAppPackaging)

maintainer := "Haifeng Li <haifeng.hli@gmail.com>"

packageName := "smile"

packageSummary := "Smile"

packageDescription := "Statistical Machine Intelligence and Learning Engine"

executableScriptName := "smile"

bashScriptExtraDefines += """addJava "-Dsmile.home=${app_home}""""

bashScriptExtraDefines += """addJava "-Dscala.repl.autoruncode=${app_home}/init.scala""""

bashScriptExtraDefines += """addJava "-Dconfig.file=${app_home}/../conf/application.conf""""

// G1 garbage collector
bashScriptExtraDefines += """addJava "-XX:+UseG1GC""""

// Optimize string duplication, which happens a lot when parsing a data file
bashScriptExtraDefines += """addJava "-XX:+UseStringDeduplication""""

// SBT BuildInfo
enablePlugins(BuildInfoPlugin)

buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion)

buildInfoPackage := "smile.shell"

buildInfoOptions += BuildInfoOption.BuildTime

libraryDependencies += "org.scala-lang" % "scala-compiler" % "2.11.7"

libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.18"
