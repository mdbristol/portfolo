

Y:  loads k into register r1 
	adds register 1 with -4 and stores in register 1  
	stores  k into resigter r1
	
	if above statement negative brench to X: 
	X:  jump register 15 + 4 into register 0 stack pointer
	load value a plus 36 store in register 2 
	load value b plus 36 store in register 3
	add register 2 and 3 and store in register 4 and reset condition code
	store register 4 plus register 1 into memory c 
	start over Y - loop in till a negative number if found 
	loops 10 times 
	K:  40 
	
	
	!sets a condition code cc 
	
Y: ld [k], %r1 
addcc %r, -4, %r1
st %r1, [k]


bneg X -brench if negative 
ld [a], %r1, %r2
ld [b], %r1, %r3
addcc %r2, %r3, %r4
st %r4, %r1, [c]
ba Y 
X: jmpl %r15 + 4, %r0     jump to the resister 15 plus 4 to next instrustion if negative 
k: 40