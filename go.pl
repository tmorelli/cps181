#!/usr/bin/perl

#Get list of all branches
#get version of all branches
#each second, update list of all branches
#update version of all branches
#if there are any diffs, fetch, checkout branch
#then run whatever command we need to do!


@branches;
@versions;

sub checkForNewBranches(){
	$res = `git branch -r`;
	@tmpBranches = split /\n/, $res;

	#first Time?
	if ($#branches <= 0){
		print ("Initial Run\n");
		@branches = @tmpBranches;
		return;
	}

	#Any New Branches?
	if ($#branches == $#tmpBranches){
		print ("No New Branches\n");
		return;
	}
	#new branch
	foreach my $tmpBranch (@tmpBranches){
		$found = false;
		foreach my $branch (@branches){
			print ("Comparing: $tmpBranch: $branch\n");
			if ($branch == $tmpBranch) {
				print("Setting found to true!");
				$found = true;
			}
		}
		if ($found == false){
			print ("New Branch: $tmpBranch\n");
		}
	}
	@branches = @tmpBranches;

}

sub checkForNewVersions(){
	#first time
	if ($#versions <=0){
		foreach my $line (@branches) {
			$version = `git log -1 --format="%H" $line`;
			chomp($version);
			push (@versions, $version);
			print "$line:$version\n";
		}
	}

	if ($#versions != $#branches){
		#new branch!!
	}
	

}

sub main(){
	while (1==1){
		checkForNewBranches();
		checkForNewVersions();
		sleep(1);

	}

}
main();




