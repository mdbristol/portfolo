import java.util.*;
/**
This class pulls all of the information from the Homework6Input class and passes that data into numerous functions.
*/
public class Homework6Functions
{
/**
The go function uses the information from the other functions in this class to compile the data and then that data is called to the Homework6Driver.
*/
	public void go()
	{
		Scanner scan = new Scanner(System.in);
		Homework6Input parser = new Homework6Input(); //allows the program to get information from the "Homework6Input" class
		String input, Monster1, Monster2;
		double M1HP,M2HP,M1WA,M1SA,M2WA,M2SA;
		input = parser.readInput(); //gets information from the "readInput" function in "Homework6Input" class.
		Monster1 = parser.getMonster1Type(input); //pulls the "type" of Monster1 from the input	(fire,water or earth)
		Monster2 = parser.getMonster2Type(input); //pulls the "type" of Monster2 from the input	(fire,water or earth)
		double M1Mod = this.Multiplier(Monster1, Monster2); //gets the multiplier for the first monster pulled from the input		
		double M2Mod = this.Multiplier(Monster2, Monster1); //gets the multiplier for the second monster pulled from the input		
		double Monster1WA = this.M1Hit1(input,M1Mod); //how many hits it takes for Monster1's WEAK attack to kill Monster2
		System.out.println(Monster1WA);
		double Monster1SA = this.M1Hit2(input,M1Mod); //how many hits it takes for Monster1's STRONG attack to kill Monster2
		System.out.println(Monster1SA);
		double Monster2WA = this.M2Hit1(input,M2Mod); //how many hits it takes for Monster2's WEAK attack to kill Monster2
		System.out.println(Monster2WA);
		double Monster2SA = this.M2Hit2(input,M2Mod); //how many hits it takes for Monster2's STRONG attack to kill Monster2
		System.out.println(Monster2SA);
		if((Monster1WA < Monster2WA) && (Monster1SA < Monster2SA))//this if/else if() series prints out who won the fight and my what margin
			{
			System.out.println("M1 Dominates M2");
			}
		else if((Monster2WA < Monster1WA) && (Monster2SA < Monster1SA))
			{
			System.out.println("M2 Dominates M1");
			}
		else if((Monster1SA < Monster2SA) && (Monster1WA == Monster2WA))
			{
			System.out.println("M1 beats M2");	
			}
		else if(Monster2SA < Monster1SA && Monster2WA == Monster1WA)
			{
			System.out.println("M2 beats M1");
			}
		else if((Monster1SA == Monster2SA) && (Monster1WA < Monster2WA))
			{
			System.out.println("M1 beats M2");
			}
		else if((Monster2SA == Monster1SA) && (Monster2WA < Monster1WA))
			{
			System.out.println("M2 beats M1");
			}
		else if((Monster1WA == Monster2WA) && (Monster1SA == Monster2SA))
			{
			System.out.println("M1 and M2 are of similar strength");
			}
		else if((Monster2WA == Monster1WA) && (Monster2SA == Monster1SA))
			{
			System.out.println("M2 and M1 are of similar strength");
			}
			else
				{
				System.out.println("there should not be an ELSE");
				}		
	}
/**
Function that returns a modifier determined by which two elemental types are fighting.
@param m1 the elemental type of Monster1
@param m2 the elemental type of Monster2
@return returns the attack modifier based on the elemental type
*/
	public double Multiplier(String m1,String m2)
	{	
	if(m1.equals("Earth") && m2.equals("Water"))
		{
		return .80;
		}
	else if(m1.equals("Earth") && m2.equals("Fire"))
		{
		return 1.2;
		}
	else if(m1.equals("Water") && m2.equals("Earth"))
		{
		return 1.2;
		}
	else if(m1.equals("Water") && m2.equals("Fire"))
		{
		return .80;
		}
	else if(m1.equals("Fire") && m2.equals("Earth"))
		{
		return .80;
		}
	else if(m1.equals("Fire") && m2.equals("Water"))
		{
		return 1.2;
		}
		else
			{
			return 1;
			}
   	}
   /**
Function that returns the number of hits it takes for a monster to kill another monster
@param HP the amount of hitpoints each monster has
@param damage the amount of damage a monters does to another monster
@return returns the number of hits it takes a monster takes to kill another monster
*/
	public double calcNumHits(double HP,double damage)
	{
	return (HP/damage);	
	}
/**
Function that returns how many WEAK hits it takes for Monster1 to kill Monster2
@param input gets Monster2HP and Monster1Attack1 from the information put into the command prompt by the user
@param modifier is the modifier determined by the elemental types fighting.  this modifier is multiplied by the Monster1Attack1.
@return returns how many WEAK hits it takes for Monster1 to kill Monster2 based on the input information and the multiplier.
*/
	public double M1Hit1(String input, double modifier)
	{
	Homework6Input parser = new Homework6Input();	
	return this.calcNumHits(parser.getMonster2HP(input), parser.getMonster1Attack1(input)*modifier);
	}
/**
Function that returns how many STRONG hits it takes for Monster1 to kill Monster2
@param input gets Monster2HP and Monster1Attack2 from the information put into the command prompt by the user
@param modifier is the modifier determined by the elemental types fighting.  this modifier is multiplied by the Monster1Attack2.
@return returns how many STRONG hits it takes for Monster1 to kill Monster2 based on the input information and the multiplier.
*/
	public double M1Hit2(String input, double modifier)
	{
	Homework6Input parser = new Homework6Input();	
	return this.calcNumHits(parser.getMonster2HP(input), parser.getMonster1Attack2(input)*modifier);
	}
/**
Function that returns how many WEAK hits it takes for Monster2 to kill Monster1
@param input gets Monster1HP and Monster2Attack1 from the information put into the command prompt by the user
@param modifier is the modifier determined by the elemental types fighting.  this modifier is multiplied by the Monster2Attack1.
@return returns how many WEAK hits it takes for Monster2 to kill Monster1 based on the input information and the multiplier.
*/
	public double M2Hit1(String input, double modifier)
	{
	Homework6Input parser = new Homework6Input();	
	return this.calcNumHits(parser.getMonster1HP(input), parser.getMonster2Attack1(input)*modifier);
	}
/**
Function that returns how many STRONG hits it takes for Monster2 to kill Monster1
@param input gets Monster1HP and Monster2Attack2 from the information put into the command prompt by the user
@param modifier is the modifier determined by the elemental types fighting.  this modifier is multiplied by the Monster2Attack2.
@return returns how many STRONG hits it takes for Monster2 to kill Monster1 based on the input information and the multiplier.
*/
	public double M2Hit2(String input, double modifier)        
	{
        Homework6Input parser = new Homework6Input();	
	return this.calcNumHits(parser.getMonster1HP(input), parser.getMonster2Attack2(input)*modifier);
        }
	
			
}
