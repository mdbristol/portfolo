!Part A
.begin 


X:   10
Y:	X

.org 2048 
a_start .equ 3000
	ld [X], %r1
	st %r1, y
	
.end 


!Part B


.begin 

x: 1


.org 2048
a_start .equ 3000

	ld[x], %r1
	st %r1, a
	ld[a], %r2
	addcc %r2, 1, %r3
	addcc %r3, 1, %r4
	addcc %r4, 1, %r5
	
	
.end

!Part c
.begin 

x: 0
.org 2048
a_start .equ 3000

i: 0

ld[x] , %r1
ld[i] , %r2

loop:    addcc %r2, -5, %r0
		be close 
		st %r1, [x]
		addcc %r2, 1, %r2
		ba loop
close: jmpl %r15 + 4 
.end


!Part d

.beign 

i: 1
j: 0 
inc: 0
temp: 0
.org 2048
a_start .equ 3000

ld[i] , %r1
ld[j] , %r2
ld[inc] , %r3
ld[temp] , %r4

while:  addcc %r1, -1,%r0 
		
		be code 
		addcc %r2, -1,%r0
		be code 
		be close
		
		code: st %r1, %r4
				andcc %r1, %r2, %r1
		
	
		st %r1, [i]
		st %r4, [j]
		addcc %r3, 1, %r3
		
		ba while
close: jmpl %r15 + 4 
.end 
