#  Radford University
#  May 8, 1996
#  .xinitrc
#
#  This file is executed when you start X-Windows and sets up your
#  initial desktop.

/bin/rm -f /home/$USER/.netscape/lock

DISPLAY=unix:0.0; export DISPLAY

xbiff -geometry 46x46+153-0 &

#142x142 is the size of the clock window
#+0 means over 0 pixels from the left edge of the screen
#-0 means up 0 pixels from the bottom
xclock -geometry 142x142+0-0 &

xconsole  -geometry 372x124+208-0 &

#54x45 is the number of rows and columns for the xterm
#-0 means over 0 pixels from the right edge of the screen
#+0 means down 0 pixels from the top edge of the screen
xterm -sb                -geometry 54x45-0+0 -T "Right Window" &

xterm -sb   -cu -fn 8x13 -geometry 80x45+0+0 -T "Left Window" &

fvwm # Leave the last one in the foreground
exit 0
