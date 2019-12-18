#! /bin/bash 
###########################################
#
###########################################

# constants
baseDir=$(cd `dirname "$0"`;pwd)
rootDir=$(cd $baseDir/..;pwd)
CLASSPATH_EXT="$rootDir/app/src/main/resources:$rootDir/tools/spring/spring-aop-5.1.0.RELEASE.jar:$rootDir/tools/spring/spring-context-5.1.0.RELEASE.jar:$rootDir/tools/spring/spring-expression-5.1.0.RELEASE.jar:$rootDir/tools/spring/spring-beans-5.1.0.RELEASE.jar:$rootDir/tools/spring/spring-core-5.1.0.RELEASE.jar:$rootDir/tools/spring/spring-jcl-5.1.0.RELEASE.jar"

# functions

# main 
[ -z "${BASH_SOURCE[0]}" -o "${BASH_SOURCE[0]}" = "$0" ] || return

if [ -z "$1" ]; then
    echo "Usage: $0 JAVA_CLASS_FULLNAME"
    echo "example: $0 com.chatopera.tutorials.java.aop.Sample"
fi

javaClassFullname=$1
javaClassPath=${javaClassFullname//\./\/}

if [[ ! $javaClassPath == *".java" ]]; then
    javaClassPath=$javaClassPath.java
fi

javaClassCompiled=${javaClassPath%\.java}
echo "Compile java class " `pwd`/$javaClassPath "to" `pwd`/$javaClassCompiled "..."

cd $baseDir/../app/src/main/java
if [ -f $javaClassPath ]; then
    set -x
    javac -classpath "$CLASSPATH_EXT:`pwd`" $javaClassPath
    set +x
    if [ $? -eq 0 ]; then
        echo "Compiled successfully."
        set -x
        java -ea -classpath "$CLASSPATH_EXT:`pwd`" $javaClassCompiled
        set +x
    else
        exit $?
    fi

else
    echo "Usage: $0 JAVA_CLASS_FULLNAME"
    echo "example: $0 com.chatopera.tutorials.java.aop.Sample"
fi
