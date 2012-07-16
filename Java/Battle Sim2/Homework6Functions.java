/** his class pulls all of the information from the Homework6Input class and passes that data into numerous functions.
*/
public class Homework6Functions
{
/**The go function uses the information from the other functions in this class to compile the data and then that data is called to the Homework6Driver.
@param data is the input string 
@param parser is the defining of a class
*/
	public void go(String data, Homework6Input parser)
	{
	
	double mult1 = this.M1Multiplier(data, parser);//the damage mulit that adds on the the damage or takes of the damage
	double mult2= this.M2Multiplier(data, parser);///the damage mulit that adds on the the damage or takes of the damage
	double dmg1 =this.M1Hit1(data, parser,mult1);///damage done after first attack on monster 1
	 double dmg2 = this.M1Hit2(data, parser, mult1);//damage done after second attack on monster 1
	double dmg3 =this.M2Hit1(data, parser, mult2);//damage done after first attack on monster 2
	double dmg4= this.M2Hit2(data, parser, mult2);//damage done after second attack on monster 2
	
	if ( (dmg1 < dmg3) && (dmg2 < dmg4))///finds if both the weak attack and strong attack are both greater then the other monster
	{
		System.out.println("M2 dominates M1");
	}
	else if ((dmg4 < dmg2) && (dmg3 < dmg1))//finds if both the weak attack and strong attack are both greater then the other monster
	{
		System.out.println("M1 dominates M2");
	}
	else if(dmg3 > dmg1) ///finds if one stronger attack is greater then the other
	{
		System.out.println("M2 beats M1");
	}
	else if (dmg1 > dmg3)///finds if one stronger attack is greater then the other 
	{
		System.out.println(" M1 beats M2");
	}
	else if((dmg4 <dmg2) && (dmg3 == dmg1))//finds if the stringer attack are the same and who would win with the weak attack
	{
		System.out.println("M2 beats M1");
	}
	else if ((dmg4 > dmg2) && (dmg3==dmg1))//finds if the stringer attack are the same and who would win with the weak attack
	{
		System.out.println("M1 beats M2");
	}
	else if ( (dmg1 == dmg3) && (dmg2 == dmg4))//finds if the weak and strong attacks are equal
	{
		System.out.println("M1 and M2 are of similar strength");
	}
	else if ((dmg3 == dmg1) && (dmg4==dmg2))//finds if the weak and strong attacks are equal
	{
		System.out.println("M1 and M2 are of similar strength");
	}
	}
	
	
	/**Function that returns a modifier of monster 1  determined by which two elemental types are fighting.
	@param a is the inputed string 
	@param b is the Homework class 
	@return returns the inceased or decrease or damage
	*/
	public Double M1Multiplier(String a, Homework6Input b)
	{
		
		String monster = b.getMonster1Type(a);//calls a method 
		String monster1= b.getMonster2Type(a);
                        //sends the type of monster to 
	return this.calcDamage(monster,monster1); 	
		
	}
	/**Function that returns a modifier of monster 2 determined by which two elemental types are fighting.
	@param a is the inputed string 
	@param b is the Homework class 
	@return returns the inceased or decrease or damage
	*/
	public Double M2Multiplier(String a, Homework6Input b)
	{
		String monster2 = b.getMonster2Type(a);
		String monster1= b.getMonster1Type(a);
		return  this.calcDamage(monster2,monster1); 
	}
	
	
	/** Functoin will calculate the modifier ammount.
	@Param a is monster1
	@Param b is monster 2
	@return the modifier ammount
	*/
	
	public Double calcDamage(String a , String b  )
	{
	
		if (a.equals("earth") && b.equals("fire"))
			{
			return 1.2;
			}
		else if (a.equals("earth") && b.equals("water"))
			{
				return .80;
			}
			else if (a.equals("water") && b.equals("earth"))
			{
				return 1.2;
			}
			else if (a.equals("water") && b.equals("fire"))
			{
				return .80;
			}
			else if (a.equals("fire") && b.equals("water"))
			{
				return 1.2;
			}
			else if (a.equals("fire") && b.equals("earth"))
			{
				return .80;
			}
			else 
			{
				return 1.00;
			}
	}
	
	/** Functoin will calculate the modifier ammount of monster 1.
	@Param data is the inputed string
	@Param parser is the homework class
	@Param mult1 is the modifier ammount
	@return the damg ammount
	*/
	
	
	public Double M1Hit1(String data, Homework6Input parser, double mult1)
	{
		double hit = parser.getMonster1Attack1(data);//gets attack weak
		double hp = parser.getMonster1HP(data);//gets hp 
		double dmg = this.calcNumHits(hit,hp,mult1);///sends the inforamtion to be caluclated
		return dmg;
		
		
	}
	/** Functoin will calculate the modifier ammount of monster 1.
	@Param data is the inputed string
	@Param parser is the homework class
	@Param mult1 is the modifier ammount
	@return the damg ammount
	*/
	
	public Double M1Hit2(String data, Homework6Input parser, double mult1)
	{
		double hit = parser.getMonster1Attack2(data);///gets the strong attack
		double hp = parser.getMonster1HP(data);///gets hp
		double dmg = this.calcNumHits(hit,hp,mult1);///sends to calc to find answers
		return dmg;
		
	}
	/** Functoin will calculate the modifier ammount of monster 2.
	@Param data is the inputed string
	@Param parser is the homework class
	@Param mult2 is the modifier ammount
	@return the damg ammount
	*/
	
	public Double M2Hit1(String data, Homework6Input parser, double mult2)
	{
		double hit = parser.getMonster2Attack1(data);///gets weak attack
		double hp = parser.getMonster2HP(data);//gets hp of monster 2
		double dmg= this.calcNumHits(hit,hp,mult2);//calculates information
		return dmg;
	}
	/** Functoin will calculate the modifier ammount of monster 2
	@Param data is the inputed string
	@Param parser is the homework class
	@Param mult1 is the modifier ammount
	@return the damg ammount
	*/
	
	public Double M2Hit2(String data, Homework6Input parser, double mult2)
	{
		double hit = parser.getMonster2Attack2(data);///gets strong attack 
		double hp = parser.getMonster2HP(data);///gets hp
		double dmg= this.calcNumHits(hit,hp,mult2);///calculates information
		return dmg;
	}
	/** Functoin will calculate the number of hits
	@Param hit gives the ammount of damage the monster does
	@Param hp gives the hp of the monster
	@Param multi gives the modifer ammount
	@return the ammount of hits
	*/
	
	public Double calcNumHits(double hit, double hp, double multi)
	{
	double dmg = hit * multi;
	dmg = dmg + hit;
	return (hp/dmg);
	}





}
