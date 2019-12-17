#! /bin/bash
###########################################
# Sample program with AspectJ
# http://esus.com/get-started-with-aspectj/
###########################################

# constants
baseDir=$(cd `dirname "$0"`;pwd)
rootDir=$(cd $baseDir/../../../../../../../../..;pwd)

# functions

# main
[ -z "${BASH_SOURCE[0]}" -o "${BASH_SOURCE[0]}" = "$0" ] || return
cd $rootDir/app
mvn -Dtest=SecuredMethodTest#testMethod test
