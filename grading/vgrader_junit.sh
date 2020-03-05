#!/bin/bash

set -e

function extract {
	if [ -d "extract" ]; then
		echo "vGRADER: folder extract exists. aborted"
		exit 1
	fi
	for f in *.{zip,rar} 
		do
			student="${f%%_*}" 
				folder="extract/$student"
				mkdir -p "$folder" 
				cp "$f" "$folder"	
				pushd "$folder" > /dev/null 
				echo vGRADER: extracting $f to $folder
				if [ ${f: -4} == ".zip" ]
				then
					unzip "$f" > /dev/null
				else
					unrar x "$f" > /dev/null
				fi
				popd > /dev/null
		done
}

function run_one {
	find_and_remove_package
	TESTSRC=`find . -maxdepth 1 -name "*Test*.java" -print`
	TESTSRC=$(basename -- "$TESTSRC")
	TESTSRC="${TESTSRC%.*}"
	TESTPATH=/Users/pdu/teaching/CSS143B
	javac -Xlint:unchecked -cp $TESTPATH/junit/junit-4.13.jar *.java
	java -cp .:$TESTPATH/junit/junit-4.13.jar:$TESTPATH/junit/hamcrest-core-1.3.jar org.junit.runner.JUnitCore $TESTSRC 

	rm *.class
}

function find_and_remove_package {
	for f in *.java; do
		[ -f "$f" ] || break
		if grep -q "package " "$f"; then
			echo [vgrader] usage of package found 
			sed -i.bak '/package /d' *
			echo [vgrader] usage of package removed 
			return
		fi
	done
}

function run_all {
	for f in *roblem* 
		do
		pushd $f > /dev/null
		echo -----working in "$f"-----
		run_one
		popd > /dev/null
	done
}

function show_options {
    echo "Options:"
    echo "	--ex to extract"
    echo "	--run_all to run in all problem folder"
    echo "	--run_one to run in the current folder"
	echo "world at peace!"
}

if [ $# -eq 0 ]; then
	show_options
    exit 1
fi

while test $# -gt 0
do
    case "$1" in
        --ex) extract 
            ;;
        --run_all) run_all 
            ;;
        --run_one) run_one 
            ;;
        --*) echo "bad option $1"; show_options
            ;;
        *) echo "argument $1"
            ;;
    esac
    shift
done
exit 0
