//18/20
//you got 4c wrong, 4d, and 4f 
// Dice assignment
// Shashank Raghuraj
//9/21/20
//graders name-- Aashrita Kolli
// This program will 3 different methods all relating to the dice class.
//Bonus' done: 100,000 games of Craps
import java.util.Scanner;
import java.util.Arrays;
class Main {
  public static void main(String[] args) {
    System.out.println("\nRUNNING THE DICE ASSIGNMENT\n\n");
    Scanner reader = new Scanner(System.in);
    while(true)
    { 
      System.out.print("Which program would you like to run?\n1.Dice Addition\n2.Dice Array\n3.Game of Craps\n4.Simulate 100,000 games of Craps\n5.Five and One\n6.Exit\n>");
      //Looping menu
      String input = reader.next();
      if(input.equals("1")){
        DiceAddition();
      }
      else if(input.equals("2")){
        DiceTenthousand();
      }
      else if(input.equals("3")){
        Craps();
      }
      else if(input.equals("4")){
        CrapsBonus();
      }
      else if(input.equals("5")){
        OneOrFive();
      }
      else{
        break;
      }
    }
  }
  //This first method will randomly roll 2 dice: dice 1 and dice 2. This will then add up those random numbers.
  public static void DiceAddition()
  {
    Scanner reader = new Scanner(System.in);
    boolean Flag = true;
    while(Flag)
    {
      //initialize 2 die object with parameters of 6
      Dice dice1 = new Dice(6);
      Dice dice2 = new Dice(6);
      System.out.print("How many times would you like to roll the dice? ");
      int input = reader.nextInt();
      //for loop runs the program the amount of times the user inputed
      for(int i = 1; i <= input; i++){
        reader.nextLine();
        //Initializes 2 roll variables
        int roll1 = dice1.roll();
        int roll2 = dice2.roll();
        //adds up roll 1 and roll 2
        int diceSum = roll1 + roll2;
        //displays roll number and the addition
        System.out.println("Roll #" + i + "   " + roll1 + " + " +  roll2 + " = " + diceSum);
        
        System.out.println("Press ENTER to continue . . .");
      }
      //Asks user if they want to run it again
      System.out.println("Would you like to play again? (Y/N)");
      String again = reader.next();
      if(again.equalsIgnoreCase("N"))
      {
        Flag = false;
      } 
    }
    //Initialize 2 dice variables
  }
  //This method will create an array with 10000 cells. It will then roll a dice 10,000 times and print out the amount of times 1,2,3,4,5,6 are rolled
  public static void DiceTenthousand()
  {
    //Initializes 1 dice object with a parameter of 6
    Dice dice1 = new Dice(6);
    //Initializes 6 counter variables 
    //Initializes an array 
    int[] diceList = new int[6];
    //Checks to see if the array cell is equal to values 1 through 6
    for(int i =0; i < 10000; i++)
    {
      int roll = dice1.roll();
      diceList[roll-1]++;
    }
    for(int i = 0; i< 6; i++){
      System.out.println("The number of times " + (i+1) + " was rolled: " + diceList[i]);
    }
    //prints out the times each number was rolled
  }
  public static void Craps()
  {
    Scanner reader = new Scanner(System.in);
    //Initializes flag variable
    boolean Flag = true;
    //Initilizes point flag variable
    boolean pointFlag = true;
    while(Flag)
    {
      //Initializes 2 dice variables each with a parameter of 6
      Dice dice1 = new Dice(6);
      Dice dice2 = new Dice(6);
      //Initializes pointer and sets it to 0
      int point = 0;
      //initializes 2 roll variables
      int roll1 = dice1.roll();
      int roll2 = dice2.roll();
      //creates a dice sum variable
      int diceSum = roll1 + roll2;
      //if player rolls 7 or 11, then player automatically wins
      if(diceSum == 7 || diceSum == 11){
        System.out.println("Player rolled " + roll1 + " + " + roll2 + " = " + diceSum);
        System.out.println("Player wins!\n");
        System.out.print("Would you like to play again? (Y/N)");
        String input = reader.next();
        if(input.equalsIgnoreCase("N")){
          break;
        }
      }
      //if player rolls 2,3, or 12 then the player automatically loses
      else if(diceSum == 2 || diceSum == 3 || diceSum == 12){
        System.out.println("Player rolled " + roll1 + " + " + roll2 + " = " + diceSum);
        System.out.println("Player loses\n");
        System.out.print("Would you like to play again? (Y/N)");
        String input = reader.next();
        if(input.equalsIgnoreCase("N")){
          break;
        }
      }
      //If the game is continued, the player makes point
      else{
        System.out.println("Player rolled " + roll1 + " + " + roll2 + " = " + diceSum);
        point = diceSum;
        System.out.println("Point is " + point);
        while(pointFlag)
        {
          //Creates 2 new dice, each with a parameter of 6
          Dice pointDice1 = new Dice(6);
          Dice pointDice2 = new Dice(6);
          int pointRoll1 = pointDice1.roll();
          int pointRoll2 = pointDice2.roll();
          int pointSum = pointRoll1 + pointRoll2;
          System.out.println("Player rolled " + pointRoll1 + " + " + pointRoll2 + " = " + pointSum);
          //if the sum is equal to the point, then the player wins!
          if(pointSum == point){
            System.out.println("Player wins!\n");
            System.out.print("Would you like to play again? (Y/N)");
            String input = reader.next();
            if(input.equalsIgnoreCase("Y")){
              Craps();
            }
            else{
              break;
            }
          }
          //if the point sum at anytime the player looses
          else if(pointSum == 7){
            System.out.println("Player loses\n");
            System.out.print("Would you like to play again? (Y/N)");
            String input = reader.next();
            if(input.equalsIgnoreCase("Y")){
              Craps();
            }
            else{
              break;
            }
          }
        }
        break;
      }
    }
  }
  //This runs the game of graps 100000 times and calculates the experimental probability
  public static void CrapsBonus()
  {
    //Initialize 2 dice variables
    Dice dice1 = new Dice(6);
    Dice dice2 = new Dice(6);
    //Initialize a final variable, call it TOTALCRAPSTIMES
    final double TOTALCRAPSTIMES = 100000.0;
    //Initializes necessary winning and loosing variables
    int totalWins = 0;
    int totalLosses = 0;
    int totalWinsPoint = 0;
    int totalLossesPoint = 0;
    int totalWinsFirstRoll = 0;
    int totalLossesFirstRoll = 0;
    //Initializes probability counter
    double totalProbabilityCount = 0.0;
    for(int i = 0; i < TOTALCRAPSTIMES; i++)
    {
      //Initializes 2 roll variables and 1 sum variable
      int roll1 = dice1.roll();
      int roll2 = dice2.roll();
      int diceSum = roll1 + roll2;
      //This if statemnt will count both the total wins as well as the total wins on the first roll
      if(diceSum == 7 || diceSum == 11){
        totalWins++;
        totalWinsFirstRoll++;
      }
      //This if statment will count both the total losses as well as the total losses on the first roll
      else if(diceSum == 2 || diceSum == 3 || diceSum == 12){
        totalLosses++;
        totalLossesFirstRoll++;
      }
      else
      {
        //initializes a pointer variable and flag variable
        int point = diceSum;
        boolean Flag = true;
        while(Flag)
        {
          //creates the pointer algorithim
          int pointRoll1 = dice1.roll();
          int pointRoll2 = dice2.roll();
          int pointDiceSum = pointRoll1 + pointRoll2;
          //if the dice sum is equal to 7, it increases the total losses and also increases the total losses for point
          if(pointDiceSum == 7){
            totalLosses++;
            totalLossesPoint++;
            Flag = false;
          }
          //if the dice sum is equal to point, then it increases the total wins and the total wins on point
          else if(pointDiceSum == point){
            totalWins++;
            totalWinsPoint++;
            Flag = false;
          }
        }
      }
    }
    //Prints all probabilities
    System.out.println("Overall Winnning probability " + ((totalWins / TOTALCRAPSTIMES)*100) + "%\n" );

    System.out.println("Overall Loosing probability " + ((totalLosses / TOTALCRAPSTIMES)*100) + "%\n" );

    System.out.println("Overall Winning on First roll probability " + ((totalWinsFirstRoll / TOTALCRAPSTIMES)*100) + "%\n" );

    System.out.println("Overall Loosing on first roll probability " + ((totalLossesFirstRoll / TOTALCRAPSTIMES)*100) + "%\n" );

    System.out.println("Overall Winning on point probability " + ((totalWinsPoint / TOTALCRAPSTIMES)*100) + "%\n" );

    System.out.println("Overall Loosing on point probability " + ((totalLossesPoint / TOTALCRAPSTIMES)*100) + "%\n" );
  }
  public static void OneOrFive()
  {
    Scanner reader = new Scanner(System.in);
    Dice dice = new Dice(6);
    int p1TemporaryScore = 0;
    int p2TemporaryScore = 0;
    int p1PermanentScore = 0;
    int p2PermanentScore = 0;
    int amountOfDice = 5;
    boolean p1Flag = true;
    boolean p2Flag = true;
    int p1S = 0;
    int p2S = 0;
    while(true)
    {
      p1S = player1(p1PermanentScore);
      p1PermanentScore = p1S;
      if(p1PermanentScore >= 2000)
      {
        System.out.println("Player 1 has won");
        break;
      }
      p2S = player2(p2PermanentScore);
      p2PermanentScore = p2S;
      if(p2PermanentScore >- 2000)
      {
        System.out.println("Player 2 has won");
      }
    }
    
  }
  public static int player2(int peramentScore)
  {
    System.out.println("\n");
    System.out.println("Player 2 turn: ");
    Scanner reader = new Scanner(System.in);
    Dice dice = new Dice(6);
    int p2TemporaryScore = 0;
    int p2PermanentScore = peramentScore;
    int amountOfDice = 5;
    int oneOrFiveCounter = 0;
    boolean p1Flag = true;
    boolean p2Flag = true;
    do
    {
      System.out.println("\n");
      System.out.println("Your current permanent score is " + p2PermanentScore);
      int[] Scores = new int[amountOfDice];
      boolean isFullHouse = false;
      //rolls dice
      for(int i = 0; i < amountOfDice; i++)
      {
        Scores[i] = dice.roll();
      }
      //Figures score
      for(int i = 0; i < amountOfDice; i++)
      {
        if(Scores[i] == 1)
        {
          oneOrFiveCounter++;
          p2TemporaryScore+=100;
        }
        else if(Scores[i] == 5){
          oneOrFiveCounter++;
          p2TemporaryScore += 50;
        }
        else{
          p2TemporaryScore+=0;
        }
      }
      for(int i = 0; i < amountOfDice; i++)
      {
        if(Scores[i] != 1 || Scores[i] !=5)
        {
          isFullHouse = false;
        }
        else{
          isFullHouse = true;
        }
      }
      System.out.println("Rolls " + amountOfDice);
      System.out.println("Array: " + Arrays.toString(Scores));
      System.out.println("The temporary points you have are " + p2TemporaryScore);
      if(p2TemporaryScore == 0)
      {
        System.out.println("Temporary Points are Lost and turn is ended");
        break;
      }
      if(p2PermanentScore >= 2000)
      {
        p2Flag = false;
      }
      amountOfDice--;
      oneOrFiveCounter = 0;
      if(isFullHouse)
      {
        amountOfDice = 5;
      }
      System.out.print("Would you like to continue? (Y/N)");
      String input = reader.next();
      if(input.equalsIgnoreCase("N"))
      {
        p2Flag = false;
        peramentScore+=p2TemporaryScore;
      }
      else{
        p2Flag = true;
      }
    }while(p2Flag);
    System.out.println("You now have a Permanent Score of: " + peramentScore);
    p2PermanentScore = peramentScore;
    return p2PermanentScore;
  }//end player 1 method
  public static int player1(int peramentScore)
  {
    System.out.println("\n");
    System.out.println("Player 1's turn");
    Scanner reader = new Scanner(System.in);
    Dice dice = new Dice(6);
    int p1TemporaryScore = 0;
    int p1PermanentScore = peramentScore;
    int amountOfDice = 5;
    int oneOrFiveCounter = 0;
    boolean p1Flag = true;
    boolean p2Flag = true;
    do
    {
      System.out.println("\n");
      System.out.println("Your current permanent score is " + p1PermanentScore);
      //Initializes Score array
      int[] Scores = new int[amountOfDice];
      boolean isFullHouse = false;
      //rolls dice
      for(int i = 0; i < amountOfDice; i++)
      {
        Scores[i] = dice.roll();
      }
      //Figures score
      for(int i = 0; i < amountOfDice; i++)
      {
        if(Scores[i] == 1)
        {
          oneOrFiveCounter++;
          p1TemporaryScore+=100;
        }
        else if(Scores[i] == 5){
          oneOrFiveCounter++;
          p1TemporaryScore += 50;
        }
        else{
          p1TemporaryScore+=0;
        }
      }
      for(int i = 0; i < amountOfDice; i++)
      {
        if(Scores[i] != 1 || Scores[i] != 5)
        {
          isFullHouse = false;
          break;
        }
        else{
          isFullHouse = true;
        }
      }
      System.out.println("Rolls " + amountOfDice);
      System.out.println("Array: " + Arrays.toString(Scores));
      System.out.println("The temporary points you have are " + p1TemporaryScore);
      if(oneOrFiveCounter == 0)
      {
        System.out.println("Temporary Points are Lost and turn is ended");
        break;
      }
      if(p1PermanentScore >= 2000)
      {
        p1Flag = false;
      }
      amountOfDice--;
      oneOrFiveCounter = 0;
      if(isFullHouse)
      {
        amountOfDice = 5;
      }
      System.out.print("Would you like to continue? (Y/N)");
      String input = reader.next();
      if(input.equalsIgnoreCase("N"))
      {
        p1Flag = false;
        peramentScore+=p1TemporaryScore;
      }
      else{
        p1Flag = true;
      }
    }while(p1Flag);
    System.out.println("You now have a Permanent Score of: " + peramentScore);
    p1PermanentScore = peramentScore;
    return p1PermanentScore;
  }
} 
