import java.util.*;
public class Homework6Input
{
	public String readInput()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the 1st monster's information");
		String monster1 = scan.nextLine();
		System.out.println("Enter the 2nd monster's information");
		String monster2 = scan.nextLine();
		String m3 = monster1.concat(":");
		m3 = m3.concat(monster2);
		return m3;
	}
	public String getMonster1Type(String input)
	{
		return input.substring(0, input.indexOf('|'));
	}
	public String getMonster2Type(String input)
	{
		return input.substring(input.indexOf(':')+1, input.lastIndexOf('|'));
	}
	public double getMonster1HP(String input)
	{
		return Double.valueOf(input.substring(input.indexOf('|')+1, input.indexOf(',')));
	}
	public double getMonster2HP(String input)
	{
		return Double.valueOf(input.substring(input.lastIndexOf('|')+1, input.lastIndexOf(',')));
	}
	public double getMonster1Attack1(String input)
	{
		return Double.valueOf(input.substring(input.indexOf(',')+1, input.indexOf('-')));
	}
	public double getMonster2Attack1(String input)
	{
		return Double.valueOf(input.substring(input.lastIndexOf(',')+1, input.lastIndexOf('-')));
	}
	public double getMonster2Attack2(String input)
	{
		return Double.valueOf(input.substring(input.lastIndexOf('-')+1, input.length()));
	}
	public double getMonster1Attack2(String input)
	{
		return Double.valueOf(input.substring(input.indexOf('-')+1, input.indexOf(':')));
	}
}
