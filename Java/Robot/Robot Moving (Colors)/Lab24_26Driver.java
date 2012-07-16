public class Lab24_26Driver
{
	public static void main (String[] args)
	{
		
		Robot rob = new Robot();
		Lab24_26b fc = new Lab24_26b(1,2,3);
		Lab24_26_2 fc1 = new Lab24_26_2("red",0);
		Lab24_26_2 fc2 = new Lab24_26_2("black",0);
		Lab24_26_2 fc3 = new Lab24_26_2("white",0);
		Lab24_26c fc4= new Lab24_26c();
		String action;
		String color1; 
		String color2;
		String color3; 
		String color4;
		String command = "0";
		action=rob.readColor();//has to read the first value //not sure 
		while(!command.equals("quit"))
		{
		
		
		 if(action.equals("white"))
			{
			rob.moveForwardXFeet(0.16);
			color1=rob.readColor();
			
			 if(color1.equals("red"))
				 {
				 	
				 }
			 else if(color1.equals("black"))
			 	 {
				 	//
			 	 }
			 else if(color1.equals("white"))
			 	 {
				 	//
			 	 }
			 	 rob.moveForwardXFeet(0.16);
			 	 color2=rob.readColor();
				 
			 	 if(color2.equals("red"))
			 	 	 {
			 	 	 	 if(color1.equals("red")){fc1.colorR(fc.redN());}//if first color is red and second color is red store 1 in red
			 	 	 	 else if(color1.equals("black")){fc2.colorR(fc.redN());}//if second color is black store 1  in black because first color is red
			 	 	 	 else if(color1.equals("white")){fc3.colorR(fc.redN());}
			 	 	 }
			 	 else if(color2.equals("black"))
			 	 	 {
			 	 	 	 if(color1.equals("red")){fc1.colorR(fc.blackN());}
			 	 	 	 else if(color1.equals("black")){fc2.colorR(fc.blackN());}
			 	 	 	 else if(color1.equals("white")){fc3.colorR(fc.blackN());}
			 	 	 }
			 	 else if(color2.equals("white"))
			 	 	 {
			 	 	 	 if(color1.equals("red")){fc1.colorR(fc.whiteN());}
			 	 	 	 else if(color1.equals("black")){fc2.colorR(fc.whiteN());}
			 	 	 	 else if(color1.equals("white")){fc3.colorR(fc.whiteN());}
			 	 	 }
					 
			}	

/*Red Command
Red Multiply
White Variable 1
Black Variable 2
perform
white = white*black*/
		else if (action.equals("red"))
			{
			rob.moveForwardXFeet(0.16);
			color1=rob.readColor();
			
				 if(color1.equals("red"))
					 {
					 	 //multiply 
					 }
				 else if(color1.equals("black"))
					 {
					 	 
						
						 
						rob.displayString(fc1.ColorR() + fc1.colorT(), 0);
						rob.displayString(fc2.ColorR() + fc2.colorT(), 1);
						rob.displayString(fc3.ColorR() + fc3.colorT(), 2);
						command = "quit";
						rob.sleep(10);
						action="";
						color1=""; 
						color2="";
						color3=""; 
						color4="";
								 
						 
					 }
				 else if(color1.equals("white"))
					 {
					 	 //addition
					 }
					 rob.moveForwardXFeet(0.16);
					 color2=rob.readColor();
				 	 if(color2.equals("red"))
					        {
							
						}
					 else if (color2.equals("black"))
				 		{
							
						}
					  else if (color2.equals("white"))
						{
							//red = 1
							//black = 2
							//white = 3
						}
						rob.moveForwardXFeet(0.16);
						color3=rob.readColor();
							if(color3.equals("red")) //talk about this ....
							{
								fc4.OperationsRed(color1, color2, fc1, fc2, fc3);
							}
							else if(color3.equals("black"))
							{
								fc4.OperationsBlack(color1,color2, fc1, fc2, fc3);
							}
							else if(color3.equals("white"))
							{
								fc4.OperationsWhite(color1,color2, fc1, fc2, fc3);
							}
			}
			
		else if (action.equals("black"))
			{
			rob.moveForwardXFeet(0.16);
			color1=rob.readColor();
			
			 if(color1.equals("red"))
				 {
					 rob.moveForwardXFeet(0.16);
				 }
			 else if (color1.equals("black"))
				 {
					 rob.turnLeft();
					 rob.turnLeft();
				 }
			 else if (color1.equals("white"))
				 {
					 rob.moveBackwardXFeet(0.32); 
				 }
				 rob.moveForwardXFeet(0.16);
				 color1=rob.readColor();
				 	
			}
			rob.moveForwardXFeet(.16);
			action=rob.readColor();
		}
	}
}
