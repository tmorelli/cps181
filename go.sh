SAVEIFS=$IFS
IFS=$(echo -en "\n\b")
for branch in $(git branch -r)
do
#  version = $(git log -1 --format="%H" $branch)
  cmd="git log -1 --format=\"%H\" $branch"
  echo $cmd
  $cmd
#  git log -1 --format="%H" $branch 
#  version=$(`git log -1 --format=\"%H\" $branch`)
#  $version = $(`git log -1 --format="%H" $branch`)
#  echo $branch
#  echo $version
done
IFS=$SAVEIFS
