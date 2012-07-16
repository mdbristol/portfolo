/* Michael Bristol 
Itec 371
Programming Problems */

#include <sys/types.h>
#include <studio.h>
#include <unistd.h>



	int main()
	{
	pid_t pid;
		
		pid = fork()
		
		if (pid < 0) 
			{
				fprintf(stderr, "Fork Failed");
				return 1;
			}
			
		else if (pid == 0) //child
			{
				int n,i,c, a =0, b=1;
				printf(" Enter a Fibonacci for the nth term : ");
				scanf("%d",&n);
				printf("%d %d ", a,b);
				for( i=0; i<=(n-3); i++)
					{
						c= a+b;
						a=b;
						b=c;
						printf("%d ", c);
					}
			}
		else 
			{
				printf("parent is going to wait for child to print out values");
				wait(NULL);
			}
		return 0;
		
	}	
		


