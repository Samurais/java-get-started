#! /bin/bash
###########################################
# Sample program with AspectJ
# http://esus.com/get-started-with-aspectj/
###########################################

# constants
baseDir=$(cd `dirname "$0"`;pwd)
rootDir=$(cd $baseDir/../../../../../../../../..;pwd)
export PATH=$PATH:$rootDir/tools/bin

# export PATH=$PATH:~/java/aspect/bin
PKG_NAME=com.chatopera.tutorials.java.aop
CLASSPATH_EXT="$rootDir/app/src/main/java:$rootDir/tools/lib/aspectjrt.jar:$rootDir/tools/lib/aspectjtools.jar:$rootDir/tools/lib/aspectjweaver.jar"
CLASS_NAME=com.chatopera.tutorials.java.aop.Sample

# functions

# main
[ -z "${BASH_SOURCE[0]}" -o "${BASH_SOURCE[0]}" = "$0" ] || return
cd $baseDir
echo $CLASSPATH_EXT
set -x
mv HelloAspectJ.ja HelloAspectJ.java
ajc -classpath "$CLASSPATH_EXT" *.java
mv HelloAspectJ.java HelloAspectJ.ja

if [ $? -eq 0 ]; then
    echo "Compiled successfully."
    java -ea -classpath "$CLASSPATH_EXT" $CLASS_NAME
else
    echo "Error happens."
    exit $?
fi
