import java.util.*;
public class Lab25a
{
	public String name;
	public double income;
	
	public Lab25a(String Name, double Income)
	{
		name = Name;
		income = Income;
	}
	public String empName()
	{
	Scanner scan = new Scanner(System.in);
	return name = scan.nextLine();
	}
	public double empIncome()
	{
	Scanner scan = new Scanner(System.in);
	return income = scan.nextDouble();
	}
	
}
