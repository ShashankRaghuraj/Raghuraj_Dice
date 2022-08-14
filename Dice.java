public class Dice             // public -- so it can be instantiated by other classes
{
	// Instance variables
	private int myRollCount; // a useless variable:  how many times has this die been rolled
	private int mySides;     // how many sides on the die
	private String diceName; // another useless variable, but every die should have a name, right?
	
	//Instance methods
	
	public Dice(int sides)	//Constructor method -- requires ONE parameter
	{
		myRollCount = 0;      // You will never use this variable 
		mySides = sides;
		diceName = "Hamlet";  // Now that is just silly 
	}
	
	public int roll()   // This is the method you will use repeatedly.  It is a VERY important method! Yay, rolling!
	{
		/* Example if mySides = 6
		 * Math.random() generates range [0,1) 
		 * *mySides  -- the range becomes [0,6)
		 * (int) -- the range becomes 0,1,2,3,4,5
		 * +1 -- the range becomes 1,2,3,4,5,6 */

		int randomNum = (int)(Math.random()*mySides)+1;
		myRollCount++;
		return randomNum;
	}
	
	//ACCESSOR Methods
		
	//You will probably never use this method.  However, it returns the number of sides the die object has.	
	public int numSides()
	{
		return mySides;
	}
	
	//You will NEVER use this either.  It returns the number of times the die has been rolled since it was created.
	public int numRolls()
	{
		return myRollCount;
	}
	
	//Returns the name of the die.  You will never use this method either
	public String getName()
	{
		return diceName;
	}
	
}











