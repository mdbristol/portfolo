import java.util.*;
/** The class is made to take all the infomration from all the other classes and battle the two sides against each other intill one wins. It then will battle the next trainer asked.
*/
public class HW10Battle
{
/** The function Beginattack is the main part of this class. It determines which trainer goes with which name. Determines which trainer should fight who.Then determines which pokemon in the array belongs to which trainer. 
This function will also output different commands depending on the outcome from the battle between pokemon.
@param people takes in the array of the names of the trainers.
@param numTrainer will act as the index for finding the trainers in the array
@param scan takes in the object Scanner
*/
public void Beginattack(HW10Trainer[] people, int numTrainer,Scanner scan)
{
String name1, name2;
name1=scan.next();//reads the first part and sets it as a string 
name2=scan.next();//reads the second part and sets it as a string 
scan.nextLine();
HW10Trainer a = new HW10Trainer();//pre set
HW10Trainer b= new HW10Trainer(); 

for (int i =0; i<numTrainer; i++)///matches the trainer with there name
{
	if(name1.equals(people[i].getName()))//determines which trainer in the array goes with this name
	{
		a=people[i];
	}
	if(name2.equals(people[i].getName()))
	{
		b=people[i];
	}
}
int max1,max2;
max1=a.getNumMonsters();//gets the total amount of pokemen for that trainer
max2=b.getNumMonsters();
int curr1,curr2; //acts as the index place value for the array 
curr1=0;//starts the array at poistion 0
curr2=0;
HW10Monster side1,side2;//sets the side for the battle 
side1= a.getMonster(curr1);//sets side one for all of the first trainers monsters
side2=b.getMonster(curr2);//side two = all seconds trainers monsters
System.out.println(a.getName() + " is fighting " + b.getName());
System.out.println("Starting battle is " + side1.name + " versus " + side2.name);
while(curr1 < max1 && curr2<=max2)//if curr1 is less then max  and curr2 is less then max2 then run
{
	
	int result = fight(side1,side2,a,b);//sends the fight method the pokemon information and the Trainers information
if(result==1)
{
	System.out.println(b.getName() +"'s " + side2.name + " lost");
	curr2++;//if side 2 is losing / below 1 then call next monster
	if(curr2<max2)
		side2=b.getMonster(curr2);
	System.out.println(b.getName() + " is bringing out " + side2.name);
}
 else if(result == 2)
{
	System.out.println(a.getName() +"'s " + side1.name + " lost");
	curr1++;//if side 1 is losing/ below 1 the call next monster
	if(curr1<max1)
		side1=a.getMonster(curr1);
	System.out.println(a.getName() + " is bringing out " + side1.name);
}
 else if(result == 3)
{
	System.out.println("*Draw*");
	System.out.println(a.getName() +"'s " + side1.name + " lost");
	curr1++;//if side 1 is losing/ below 1 the call next monster
	if(curr1<max1)
		side1=a.getMonster(curr1);
	
	System.out.println(a.getName() + " is bringing out " + side1.name);
	System.out.println(b.getName() +"'s " + side2.name + " lost");
	curr2++;//if side 2 is losing / below 1 then call next monster
	
	if(curr2 < max2)
		side2=b.getMonster(curr2);
	System.out.println(b.getName() + " is bringing out " + side2.name);
	System.out.println("* End Draw *");
}


	
}
	if( curr1<max1 && curr2>max2)//if the first trainer still has pokemon and the second does not
	{
		System.out.println(a.getName() + " won the match");
	}
	else if (curr2<max2 && curr1>max1)//if the second trainer still has pokemon and the first does not
	{
		
		System.out.println(b.getName() + " won the match");
	}
	else if(curr2<max2 && curr1<max1)//if both sides dont have any pokemon left
		System.out.println("Battle is a draw");

}
/** The method will acts as the actual battle part. It will determine the extra damage or not. It will conduct the caculates for the battle.
@param a takes the information for the first trainers monsters
@param b takes the information for the second trainers monsters
@param a1 takes the information about the first trainer 
@param b1 takes the infomration about hte second trainer
@return 1 returns if the second trainers pokemon at that point is below 1 hp
@return 2 returns if the first trainers pokemon at that point is below 1 hp
@return 3returns if the first and second trainers pokemon at that point is below 1 hp
@return 5 this return does nothing
*/
public int fight(HW10Monster a, HW10Monster b,HW10Trainer a1,HW10Trainer b1 )
	{
		
		if(a.type.equals("earth") && b.type.equals("fire"))//determines which case the pokemon will have a stronger or weaker type attack power
			{
				a.damage= (int)(a.damage + (.30*a.damage));//sets the first trainers pokemon attack to be extra strong against the seconds trainer pokemon
				b.damage=(int)(b.damage - (.30*b.damage));
			}
		else if(a.type.equals("earth") && b.type.equals("water"))
			{
				a.damage= (int)(a.damage - (.30*a.damage));
				b.damage=(int)(b.damage + (.30*b.damage));
			}
		else if(a.type.equals("water") && b.type.equals("earth"))
			{
				a.damage= (int)(a.damage + (a.damage*.30));
				b.damage=(int)(b.damage - (b.damage*.30));
			}
		else if(a.type.equals("water") && b.type.equals("fire"))
			{
				a.damage= (int)(a.damage - (a.damage*.30));
				b.damage=(int)(b.damage + (b.damage*.30));
			}
		else if(a.type.equals("fire") && b.type.equals("earth"))
			{
				a.damage= (int)(a.damage - (a.damage*.30));
				b.damage=(int)(b.damage + (b.damage*.30));
			}
		else if(a.type.equals("fire") && b.type.equals("water"))
			{
				a.damage= (int)(a.damage + (a.damage*.30));
				b.damage=(int)(b.damage - (b.damage*.30));
			}
		
				
				
			while(a.hp>0 && b.hp>0)//while both pokemon are still above zero continue to take away hp
			{
				a.hp=a.hp - b.damage;
				b.hp=b.hp - a.damage;
		
			
			  if(a.hp<1 && b.hp<1)//if  pokemon are below 1 
			  	{
		
				return 3;
				}
			else if(a.hp>1 && b.hp<1) 
				{
					
					return 1;
				}
			 else if (a.hp<1 && b.hp>1)
				{
					
					return 2;
				}
			
			
			}
	
			return 5;
	}
	
}

