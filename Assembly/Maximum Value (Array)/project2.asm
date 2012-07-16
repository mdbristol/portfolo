! Finding the max value from and array of numbers 

.begin
	max: 0
	temp: 0 
.org 2048


a_start  .equ 4000 !Address of the array a

	     !register1 loads the starting address into register 1 
		 !register2 loads the size of the array 
		 !register3  loads the max_value
		 !register4  pointer for the array 
		 !register5 holds an temp element or element to campare 
		 !register6 holds nothing 
	
	ld [address], %r1  !load the starting address into register 1 
	ld [length], %r2   !l0ad the size of the array into register 2
	andcc %r3, %r0, %r3 !equals 0 
	ld %r1, %r3 !loads the value at address 4000 into register 3 
	st %r3, [max] !sets the first place in the array to the max value 
	addcc %r1, 4, %r4
loop: andcc %r2, %r2, %r0 !If the end of the array has been reached 
	 be done ! when length = 0 
	  
	  ld %r4, %r5 !load the next element into register 5 
	  st %r5, [temp]	! store regoster 5 into memory temp 
	  subcc %r3, %r5, %r0 ! subtract register 3 to register 5 
	 bneg swap !if negative value then new max found 
afterswap:  addcc %r2, -1, %r2  !Decrement the array length 
	 addcc %r4, 4, %r4 !gets the next array element 
	 ld[max] , %r3 !loads the new max from the swap into register 3 
	 
	 ba loop !loop back 
	 
swap: 
	
	  st %r3, [temp] !stores the new max
	   st %r5, [max] !store the old max 
	   
	   ba afterswap  !branch always to the afterswap
		
	 
	 
done:  st %r3, [max] !This stores the finally max value from register 3 into memory 
	 jmpl %r15+4, %r0

length:  9   !length + 4 will find the next place in array 
address:      a_start
			
	.org  a_start	
	
a: 	  1
	  22
	  10
	  5
      3
	  11
      45
	  100
	  345
.end	  