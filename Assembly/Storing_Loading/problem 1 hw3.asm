

.begin 
	x:  25
	y:	50
	.org 2048 
a_start .equ 3000
	ld[x], %r1
	ld[y], %r2

	st %r1, [y]
	st %r2, [x]
	
.end



