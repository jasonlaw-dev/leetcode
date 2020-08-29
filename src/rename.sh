#!/bin/bash
num=0
for filename in $(ls | grep -v "(" | grep -E "(java|cpp|py)$")
do
  #echo $filename
  extension="${filename##*.}"
  filenameNew="${filename/.${extension}/(revision-0).${extension}}"
  filenameToSearch="${filename/.${extension}/(*).*}"
  for f in $filenameToSearch; do
    if [ -f "$f" ]; then
      echo "Skipping $filename"
    else 
      num=$(( $num + 1 ))
      mv "$filename" "$filenameNew"
    fi
    break
  done
done
echo "Moved $num"