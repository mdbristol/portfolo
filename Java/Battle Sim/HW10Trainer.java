import java.util.*;
/** This class purpose is to make a trainer and also store the number of monsters that trainer is going to use.
This class will also use methods calls to send or pass infomration to the monsters classs and the battle class.
*/
public class HW10Trainer
{
private String Name;//has the name private so know one can change the name once it be made
private HW10Monster[] pet;//sets so that we are able to have mult monsters and is stored in pets
/** The readInfo method job is to ask the user for the trainers name and the amount of pokemon. It will then call the monster method in the monster class and sets that number of monsters into an array.
From there it will read in the info from the monsters class and store each piece of information in an array type monster.
@param Scanner makes it so we dont have to keep creating scanner objects
*/
public void readInfo(Scanner scan)
{
Name = scan.next();//reads the first token or part of the line 
int numMonsters= scan.nextInt();//reads the next infromtation after a space and also sets the number of pokem the trainer wiill have
scan.nextLine();//returns all input remaining on the line into the string...makes the /n not appear
pet= new HW10Monster[numMonsters];//allows mult pieces of infomration to be called at once 
for( int i = 0; i<numMonsters; i++)//runs for the total pokemon the trainer has
	{
		pet[i]= new HW10Monster();//sets the array up
		pet[i].readInfo(scan);//asks for all the information about each pokemon from the monster class
	}
}
/** The function getName is here because we have the varable name set as private so to be able to call this name we have to make a copy and then return it to be able to use.
@return Name will return the trainers name when called.
*/
public String getName()
{
	return Name;//returns the name of the trainer
}
/** This function uses the array type HW10Monster so that we are able to store mult pieces of infomration from it. It then will call each monster starting at zero and will call each index that is passes to it in order of the array.
@param place gets the index value of where the array needs to access.
@return will the return all the data that corrisponds with that pet in that part of the array.
*/
public HW10Monster getMonster(int place)//needs a getMonster because of the private variable made and its setting mult things in a array so by calling the monster class we are able to use mult pieces in a array.
{
	return pet[place].clone();// make it so that the the pokemen stats are reselt
}
/** This function job is to return how many pokemon the trainer is going to be using.
@return pets deteremine the length of the array or size of that array in which the monsters are being held.
*/
public int getNumMonsters()
{
	return pet.length;//returns how many monsters
}

}
