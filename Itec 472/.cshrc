#Linux_Support  --DO NOT REMOVE THIS LINE !!!
#This .cshrc was copied to your directory to support Linux. The appropriate
#File will be called when logging in. Either .cshrc.solaris or .cshrc.linux
#

if (`uname` == "Linux") then
   source $home/.cshrc.linux
else
   source $home/.cshrc.solaris
endif
