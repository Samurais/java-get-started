#! /bin/bash 
###########################################
#
###########################################

# constants
baseDir=$(cd `dirname "$0"`;pwd)
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
    javac $javaClassPath
    set +x
    if [ $? -eq 0 ]; then
        echo "Compiled successfully."
        set -x
        java -ea -classpath "`pwd`" $javaClassCompiled
        set +x
    else
        exit $?
    fi

else
    echo "Usage: $0 JAVA_CLASS_FULLNAME"
    echo "example: $0 com.chatopera.tutorials.java.aop.Sample"
fi
