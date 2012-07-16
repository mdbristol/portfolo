import java.util.*;
public class Battle
{
	public void startFight(Trainer[] people, int numTrainers)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter players that will battle");
		String name1, name2;
		name1= scan.next();
		name2=scan.next();
		scan.nextLine();
		Trainer a = new Trainer();
		Trainer b = new Trainer();
		Monster one, two;
		for (int i=0; i<numTrainers; i++)
		{
			if (name1.equals(people[i].getName()))
			{
				a = people[i];
			}
			if (name2.equals(people[i].getName()))
			{
				b = people[i];
			}
		}
		int max1, max2;
		max1 = a.numMonsters();
		max2 = b.numMonsters();
		int curr1,curr2;
		curr1=curr2=0;
		Monster side1,side2;
		one = copyMonster(a.getMonster(curr1));
		two = copyMonster(b.getMonster(curr2));
		while(curr1 < max1  || curr2 < max2)
		{
			int result = fight(one,two);
			if (result == 1)
			{
				curr2++;
				two = b.getMonster(curr2);
				System.out.println(b.getName() + " is bringing out " + two.monsterName);
				result = fight(one,two);
				
			}
			else if(result == 2)
			{
				curr1++;
				one = a.getMonster(curr1);
				System.out.println(a.getName() + " is bringing out " + one.monsterName);
				result = fight(one,two);
				
			}
			else if(result == 3)
			{
				curr2++;
				two = b.getMonster(curr2);
				System.out.println(b.getName() + " is bringing out " + two.monsterName);
				result = fight(one,two);
				
				curr1++;
				one = a.getMonster(curr1);
				System.out.println(a.getName() + " is bringing out " + one.monsterName);
				result = fight(one,two);
				
			}
		}
		//}
		if(curr1<max1 || curr2>max2)
			{
			System.out.println(one + " wins");
			}
		else if(curr2<max2 && curr1>max1)
			{
			System.out.println(two + " wins");
			}
		else
			{
			System.out.println("Battle was a draw");
			}
	
	}
	public int fight(Monster one, Monster two)
	{
		
		if(one.monsterType.equals("earth") && two.monsterType.equals("water"))
			{
				one.monsterDamage = (int)(one.monsterDamage * .70);
				two.monsterDamage = (int)(two.monsterDamage * 1.3);
			}
		if(one.monsterType.equals("earth") && two.monsterType.equals("fire"))
			{
				one.monsterDamage = (int)(one.monsterDamage * 1.3);
				two.monsterDamage = (int)(two.monsterDamage * .70);
			}
		if(one.monsterType.equals("water") && two.monsterType.equals("earth"))
			{
				one.monsterDamage = (int)(one.monsterDamage * 1.3);
				two.monsterDamage = (int)(two.monsterDamage * .70); 
			}
		if(one.monsterType.equals("water") && two.monsterType.equals("fire"))
			{
				one.monsterDamage = (int)(one.monsterDamage * .70);
				two.monsterDamage = (int)(two.monsterDamage * 1.3);
			}
		if(one.monsterType.equals("fire") && two.monsterType.equals("earth"))
			{
				one.monsterDamage = (int)(one.monsterDamage * .70);
				two.monsterDamage = (int)(two.monsterDamage * 1.3);
			}
		if(one.monsterType.equals("fire") && two.monsterType.equals("water"))
			{
				one.monsterDamage = (int)(one.monsterDamage * 1.3);
				two.monsterDamage = (int)(two.monsterDamage * .70);
			}
		else
			{
				one.monsterDamage = one.monsterDamage;
				two.monsterDamage = two.monsterDamage;
			}
			while(one.monsterHP >0 && two.monsterHP>0)
			{
			one.monsterHP = one.monsterHP - two.monsterDamage;
			System.out.println(one.monsterHP);
			two.monsterHP = two.monsterHP - one.monsterDamage;
			System.out.println(two.monsterHP);
			}
			
			if((one.monsterHP>1) && (two.monsterHP<1))
				{
				return 1;
				}
			else if((one.monsterHP<1) && (two.monsterHP>1))
				{
				return 2;
				}
			else if((one.monsterHP<1) && (two.monsterHP<1))
				{
				return 3;
				}
			else
				{
				return 10;
				}
	}
	public Monster copyMonster(Monster one)
	{
		Monster mon = new Monster("","",0.0,0.0);
			mon = one;
		return mon;
	} 
}

