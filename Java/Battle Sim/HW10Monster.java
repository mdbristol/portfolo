import java.util.*;
/** This class purpose is to create a monster with mult variables in it. It then scans in the data from the user. Also it makes a copy of the monster so that the original is not used.
Makes the variables public so that changes can be made in some places. 
*/
public class HW10Monster
{
public String name;
public String type;
public int hp;
public int damage;
/** This contructor job is to initalize the variables to be used later
*/
public HW10Monster()
{
	hp=0;
	damage=0;
	type="blank";
	name="blank";
}
/**This function purpose is to take in the a scanner and then read in all the pieces of information needed.
@param scan is the object that is passes from the driver
*/
public void readInfo(Scanner scan)
{
name= scan.next();//reads the first part and sets it as a string
type=scan.next();//reads the second part and sets it as a string
hp=scan.nextInt();//reads the thrid part and sets it as a int
damage=scan.nextInt();//reads the final paart and sets it as a int
scan.nextLine();//returns all information left
}
/** The purpose of this function is to make a copy using the readInfo from above and copy all values into another object.
@return m returns to the monster array all the copyed values.
*/
public HW10Monster clone()
{
HW10Monster m = new HW10Monster();//creates an object
m.hp=hp;//calls and makes a copy of the same value inputed
m.damage=damage;
m.type=type;
m.name=name;
return m;//returns all the variables coped values
}


}
