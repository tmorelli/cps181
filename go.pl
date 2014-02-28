#!/usr/bin/perl

#Get list of all branches
#get version of all branches
#each second, update list of all branches
#update version of all branches
#if there are any diffs, fetch, checkout branch
#then run whatever command we need to do!


@branches;
@versions;
$branchAdded = 0;
$newBranch;

sub branchUpdated{
	$branchUpdate = $_[0];
	#do something with this new branch!!
}

#################################################################
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
		$found = 0;
		foreach my $branch (@branches){
			if ($branch eq $tmpBranch) {
				$found = 1;
			}
		}
		if ($found == 0){
			print ("New Branch: $tmpBranch\n");
			$branchAdded = 1;
			$newBranch = $tmpBranch;
		}
	}
	@branches = @tmpBranches;
}

#################################################################
sub initVersions(){
	@versions = ();
	foreach my $line (@branches) {
		$version = `git log -1 --format="%H" $line`;
		chomp($version);
		push (@versions, $version);
		print "$line:$version\n";
	}
}

#################################################################
sub checkForNewVersions(){
	#first time
	if ($#versions <=0){
		initVersions();
		return;
	}
	$needToInit = 0;
	foreach my $line (@branches) {
		if (length($line) <2){
			continue;
		}
		#print("Checking: $line\n");
		$tmpVersion = `git log -1 --format="%H" $line`;
		#print("Checked: $line\n");
		chomp($tmpVersion);
		#is this version in our version list?
		#if yes, continue
		#if no, call branchupdated and set flag to update all versions

		$found = 0;
		foreach my $v (@versions) {
			if (length($v) > 2 && length($tmpVersion) > 2){
				if ($v eq $tmpVersion){
					$found = 1;
				}
			}
		}
		if ($found == 0 && length($tmpVersion) > 2) {
			branchUpdated($line);
			$needToInit = 1;
		}
	}
	if ($needToInit == 1) {
		initVersions();
	}
}


#################################################################
sub handleNewBranch(){
	initVersions();
	$branchAdded = 0;
	branchUpdated($newBranch);
}

#################################################################
sub main(){
	while (1==1){
		checkForNewBranches();
		if ($branchAdded == 1) {
			handleNewBranch();
		}
		checkForNewVersions();
		sleep(1);
	}
}
#################################################################
main();

#################################################################



