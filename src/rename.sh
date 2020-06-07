#!/bin/bash
num=0
for filename in $(ls | grep -v "(" | grep "java$")
do
  #echo $filename
  filenameNew="${filename/.java/(revision-0).java}"
  filenameToSearch="${filename/.java/(*).java}"
  for f in $filenameToSearch; do
    if [ -f "$f" ]; then
      echo "Skipping $filename"
    else 
      num=$(( $num + 1 ))
      mv "$filename" "$filenameNew"
    fi
    ## This is all we needed to know, so we can break after the first iteration
    break
  done
done
echo "Moved $num"