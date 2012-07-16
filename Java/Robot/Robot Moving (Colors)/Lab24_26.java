public class Lab24_26
{
	public int white;
	public int red;
	public int black;
	public Lab24_26()
	{
		white = 0;
		red = 0;
		black = 0;
		//red = 1
		//black = 2
		//white = 3
	}
	public void go()
	{
	Robot rob = new Robot();
	Lab24_26b fc = new Lab24_26b();
	String color = rob.readColor();//dont need 
	String action = rob.readColor();
	String color1 = rob.readColor();
	String color2 = rob.readColor();
	String color3 = rob.readColor();
	String color4 = rob.readColor();
	String command = "0";
	
	while(!command.equals("quit"))
	{
		action=rob.readColor();//has to read the first value //not sure 
		if(color1.equals("red"))
			{
			rob.moveForwardXFeet(0.16);
			color2=rob.readColor();//reads next color
			if(color2.equals("black"))
				{
				rob.displayInt(white, 0);
				rob.displayInt(red, 1);
				rob.displayInt(black, 2);
				command = "quit";
				rob.sleep(10);
				}
			}
			
	else if(action.equals("white"))
		{
			rob.moveForwardXFeet(0.16);
			color1=rob.readColor();
			
			 if(color1.equals("red"))
				 {
				 	// ..first value not to do anything!
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
			 	 	 	 if(color1.equals("red")){this.red=fc.redN();}//if first color is red and second color is red store 1 in red
			 	 	 	 else if(color1.equals("black")){this.black=fc.redN();}//if second color is black store 1  in black because first color is red
			 	 	 	 else if(color1.equals("white")){this.white=fc.redN();}
			 	 	 }
			 	 else if(color2.equals("black"))
			 	 	 {
			 	 	 	 if(color1.equals("red")){this.red=fc.blackN();}
			 	 	 	 else if(color1.equals("black")){this.black=fc.blackN();}
			 	 	 	 else if(color1.equals("white")){this.white=fc.blackN();}
			 	 	 }
			 	 else if(color2.equals("white"))
			 	 	 {
			 	 	 	 if(color1.equals("red")){this.red=fc.whiteN();}
			 	 	 	 else if(color.equals("black")){this.black=fc.whiteN();}
			 	 	 	 else if(color1.equals("white")){this.white=fc.whiteN();}
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
					 //stops program....we dont need this or something u have it at the first place
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
								if(color1.equals("red")&&color2.equals("red")){red=(red*red);}
								else if(color1.equals("red")&&color2.equals("black")){ black=(black*red);}//add
								else if(color1.equals("red")&&color2.equals("white")){white=(white*red);}
								else if(color1.equals("white")&&color2.equals("red")){red=(red+red);}
								else if(color1.equals("white")&&color2.equals("black")){black=(black+red);}
								else if(color1.equals("white")&&color2.equals("white")){white=(white +red);}
							}
							else if(color3.equals("black"))
							{
								if(color1.equals("red")&&color2.equals("red")){red=(red*black);}
								else if(color1.equals("red")&&color2.equals("black")){ black=(black*black);}//add
								else if(color1.equals("red")&&color2.equals("white")){white=(red*black);}
								else if(color1.equals("white")&&color2.equals("red")){red=(red+black);}
								else if(color1.equals("white")&&color2.equals("black")){black=(black+black);}
								else if(color1.equals("white")&&color2.equals("white")){white=(white+black);}
							}
							else if(color3.equals("white"))
							{
								if(color1.equals("red")&&color2.equals("red")){red=(red*white);}
								else if(color1.equals("red")&&color2.equals("black")){ black=(black*white);}//add
								else if(color1.equals("red")&&color2.equals("white")){white=(white*white);}
								else if(color1.equals("white")&&color2.equals("red")){red=(red+white);}
								else if(color1.equals("white")&&color2.equals("black")){black=(black+white);}
								else if(color1.equals("white")&&color2.equals("white")){white=(white+white);}
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
			action=rob.readColor();//to contiune/ or point only one at the end and not both at the begin and end
		}
	}
}
