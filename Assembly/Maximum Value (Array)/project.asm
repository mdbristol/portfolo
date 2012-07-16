! Anthony Passamonti
! November 18, 2011
! ITEC 352

! This assembly language program finds the maximum value from an array of integer values

.begin

maximum: 0
temporaryMax: 0

.org 2048

a_start		.equ 4000				! Memory address of the array

	ld [address], %r1				! Loads the start address into r1
	ld [length], %r2				! Loads the length of the array into r2
	andcc %r3, %r0, %r3				! Makes sure r3 is set to 0
	ld %r1, %r3						! Loads value at address 4000 into r3
	st %r3, [maximum]				! Stores first value in array to the maxmimum
	addcc %r1, 4, %r4
	
loop:	anddcc %r2, %r2, %r0
		be done
		ld %r4, %r5					! Loads next element into r5
		st %r5, [temporaryMax]		! Stores the value of r5 into temporaryMax
		subcc %r3, %r5, %r0			! Subtracts r3 to r5
		bneg swap2
		
swap1:	addcc %r2, -4, %r2			! Decreases array length by 4
		addcc %r4, 4, %r4			! Retrieves the next array element
		ld[maximum], %r3			! Loads the new maximum value into r3
		
		ba loop
		
swap2:	st %r3, [temporaryMax]		! Stores new maximum value
		st %r5, [maximum]			! Stores old maximum value
		
		ba swap1
		
done: 	st %r3, [maximum]			! Stores the final maximum value from r3 into memory		
		jmpl %r15 + 4, %r0
		
length:		36
address:	a_start

.org a_start

! Values in the array

a:	1
	22
	10
	5
	3
	11
	45
	100
	345
	
.end