//Sevens are considered lucky numbers. Your task is to count the number of sevens that appear within a range of numbers. Your solution should make use of looping constructs.
//
//Ask the user for the following information, in this order:
//
//The lower end of the range
//The upper end of the range
//
//Determine the number of sevens that appear in the sequence from lower end to upper end (inclusive).
//Hint: Some numbers have more than 1 seven, and not every 7 appears in the ones place.
//Hint2: Nested loops are helpful
//
//Exit on error.
public class LuckySevens
{
  public static void main(String[] args)
  {
    System.out.println("Please enter the START of your Range:"); 
    int start = IO.readInt();//Lower End of the Range

    System.out.println("Please enter the END of your Range:");
    int stop = IO.readInt();//Upper End of the Range

    if(stop<start)//This is to exit if user put a Range that makes no Sense
      return;


    int counter, power, num7=0;//Counter is the 10^counter, Power: is to get Left most positon, Num7 is number of Sevens
    for(int i = start; i <= stop; i++)
    {
      counter=0;
      power = 1;

//      System.out.println("I "+i);
//      System.out.println("Num 7 "+num7);

      for(int x =i; Math.abs(x)>10; counter++)
      {
        x/=10;
        power = 10*power;
      }
      int b=i;//Duplicates number being evaluated

      for(int d = counter;d>=0;d--)
      {

        if(Math.abs(b/power)==7)
          num7++;

        b=b-((b/power)*power);
        power/=10;

//        System.out.println("B "+b+" /" + ((b/Math.pow(10,d))*Math.pow(10,d))+" d "+d);
      }
      
    }
    IO.outputIntAnswer(num7);
  }
}
