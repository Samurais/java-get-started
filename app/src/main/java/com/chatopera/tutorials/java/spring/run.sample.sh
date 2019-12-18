#! /bin/bash 
###########################################
#
###########################################

# constants
baseDir=$(cd `dirname "$0"`;pwd)
rootDir=$(cd $baseDir/../../../../../../../../..;pwd)
PKG_NAME=com.chatopera.tutorials.java.spring
CLASSPATH_EXT="$rootDir/tools/spring/spring-aop-5.1.0.RELEASE.jar:$rootDir/tools/spring/spring-context-5.1.0.RELEASE.jar:$rootDir/tools/spring/spring-expression-5.1.0.RELEASE.jar:$rootDir/tools/spring/spring-beans-5.1.0.RELEASE.jar:$rootDir/tools/spring/spring-core-5.1.0.RELEASE.jar:$rootDir/tools/spring/spring-jcl-5.1.0.RELEASE.jar"

# functions

# main 
[ -z "${BASH_SOURCE[0]}" -o "${BASH_SOURCE[0]}" = "$0" ] || return
cd $rootDir
./scripts/run.sh $PKG_NAME.Sample
