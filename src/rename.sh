#!/bin/bash
num=0
for filename in $(ls | grep -v "(" | grep "java$")
do
  #echo $filename
  filenameNew="${filename/.java/(revision-0).java}"
  if [ -f $filenameNew ]; then
    echo "$filenameNew already exists"
  else 
    num=$(( $num + 1 ))
    mv "$filename" "$filenameNew"
  fi
done
echo "Moved $num"