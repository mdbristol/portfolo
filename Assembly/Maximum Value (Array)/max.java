//Project 2 high level view
import java.sql.*; 

public class Max 
    {
        public static void main( String args[] )
        {
            int array[] = { 1, 22 ,10 ,53,11 ,45 , 100 ,345 };
 
            int max;
 
           
 
            for (int i = 0; i < array.length; i++) {
                
				if(max < array[i])
					{
                   max = array[i]; 
					}


				}
 
            
 
            System.out.println("Max = " + max);
 
            }
}