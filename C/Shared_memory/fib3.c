/* Michael Bristol 
Itec 371
Date: 2/15/2012
The program will fork() the parent process and the child process will then determine the fib sequence
The only difference for this programn is that it is going to be using a shared memory which will
have the program write to shared_memory.

Language: c
System: Windows 7 
Instructions for complications: make fib3 
								to run: fib3
*/								

#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/shm.h>
#include <sys/stat.h>
#include<string.h>
#define MAX_SEQUENCE 10 

//make a var type holding an array and and int 
 typedef struct 
{
	long fib_sequence[MAX_SEQUENCE];
	int sequence_size;
} shared_data;






int main(int argc, char *argv[])
{

//sets up to hold the number of the proccessor 
pid_t pid;	
shared_data *p;
	//variables 
	int i,c,j,n, a =0, b=1;
	int k;
	int segment_id;	
	const int size = sizeof(shared_data);
		
			//sets the max_sequence to argv[1]
			if(atoi(argv[1]) > MAX_SEQUENCE)
			{
			printf("Size of the squence is %d \n ",MAX_SEQUENCE);
			
			}
		
		//allocate a shared memory segment
		segment_id = shmget(IPC_PRIVATE, size, S_IRUSR | S_IWUSR);
		//attach the shared memory segment
		p = (shared_data *) shmat(segment_id, NULL, 0);
		//sets sequence size to argv
		p->sequence_size = atoi(argv[1]);
		//sets up a new child process
		
		pid = fork();		

							//Code that tests from the command line it self. 
							//	while((k > MAX_SEQUENCE) ||  (k < 0))
							//	{
								//	if( k > MAX_SEQUENCE)
								//	{
								//		printf("Enter a new Fibonacchi number less then or = 10 : ");
								//		scanf("%i",&k);
								//	}
								//	else if (k < 0)
								//	{
								//		printf("Enter a new Fibonacchi number greater than 0 and less then or = 10 : ");
								//		scanf("%i",&k);
								//	}
								//	else
								//		p.sequence_size = k;
							//	}
								//p.sequence_size = k;
						

						
						
						
						
						
			if (pid < 0) //if fork fails 
			{
				fprintf(stderr, "Fork Failed");
				return 1;
			}
						
			
			else if (pid == 0) //child
			{
				//sets up the first two sequence for the arry 
				int count = 0;
						p->fib_sequence[0]= 0;
						//p.fib_sequence[0]= 0;
								printf("first value in the array %d \n", p->fib_sequence[0]);
						//p.fib_sequence[1]=1;
						p->fib_sequence[1]= 1;						
								printf("second  value in the array %d \n", p->fib_sequence[1]);
					//takes the 3 place in the array and sets up the rest of the fib_sequence		
					for( i=2; i<= (p->sequence_size); i++)
					{
						p->fib_sequence[i] = p->fib_sequence[i-1] + p->fib_sequence[i-2];
						//p.fib_sequence[i] = p.fib_sequence[i-1] + p.fib_sequence[i-2];
						
						count++;
					}
					printf(" Count = %d \n", count);
					//prints the number in the array	
					for( n=0; n<count; n++)
					{
					
					printf("*%s ", p->fib_sequence[n]);
					}
				
	
			}
	
			else //parent
			{
				wait(NULL);
				
		
				printf("\n Size of the squence is %d ", p->sequence_size);
				shmdt(p);
				shmctl(segment_id, IPC_RMID,NULL);
			}
	return 0;
}
			
	