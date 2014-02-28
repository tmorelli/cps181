SAVEIFS=$IFS
IFS=$(echo -en "\n\b")
for file in $(find . | grep java | grep Grades | grep -v Name)
do
 NEW_UUID=$(cat /dev/urandom | LC_CTYPE=C tr -dc 'a-zA-Z0-9' | fold -w 32 | head -n 1).java
 mv $file $NEW_UUID 
done
IFS=$SAVEIFS
