import java.util.*;
public class Lab25Driver
{
	public static void main(String[] args)
	{
		Lab25a one = new Lab25a("",0.0);
		Lab25a two = new Lab25a("",0.0);
		Lab25a three = new Lab25a("",0.0);
		Lab25b four = new Lab25b(0.0);
		Lab25b five = new Lab25b(0.0);
		Lab25b six = new Lab25b(0.0);
		System.out.println("Please enter first customer's name:");
		String name1 = one.empName();
		System.out.println("Please enter monthly income for " + name1);
		double income1 = one.empIncome();
		System.out.println("Please enter total year mortgage payment for " + name1);
		double payment1 = four.mPayment()/12;
		System.out.println("Please enter second customer's name:");
		String name2 = two.empName();
		System.out.println("Please enter monthly income for " + name2);
		double income2 = two.empIncome();
		System.out.println("Please enter total year mortgage payment for " + name1);
		double payment2 = five.mPayment()/12;
		System.out.println("Please enter third customer's name:");
		String name3 = three.empName();
		System.out.println("Please enter monthly income for " + name3);
		double income3 = three.empIncome();
		System.out.println("Please enter total year mortgage payment for " + name1);
		double payment3 = six.mPayment()/12;
				
		
		
		
		
		System.out.println(income1);
		System.out.println(income2);
		System.out.println(income3);
		System.out.println(payment1);
		System.out.println(payment2);
		System.out.println(payment3);
		
		if(income1*.30 < payment1)
			{
			System.out.println(name1 + "'s mortgage is good");
			}
			else
				{
				System.out.println(name1 + "'s mortgage is BAD");
				}
		if(income2*.30 < payment2)
			{
			System.out.println(name2 + "'s mortgage is good");
			}
			else
				{
				System.out.println(name2 + "'s mortgage is BAD");
				}
			
		if(income3*.30 < payment3)
			{
			System.out.println(name3 + "'s mortgage is good");
			}
			else
				{
				System.out.println(name3 + "'s mortgage is BAD");
				}
	}
}
		
