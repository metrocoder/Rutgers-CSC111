public class LuckyNines
{
  /**
   *This is a function that is used to count the number of nines that appears
   *within a range of numbers.
   *
   * Precondition: Make sure that the Numbers START and END range are legal
   *
   * Postcondition: Returns back the number of Nines that are in each number 
   *                in the given Range INCLUSIVE
   */
  public static int countLuckyNines(int lowerEnd, int upperEnd)
  {
    if(lowerEnd>upperEnd)
      return -1;
    int counter, power, num9=0;//Counter = 10^counter, Power = Left most positon, Num9 = number of 9s
    for(int i = lowerEnd; i <= upperEnd; i++)
    {
      counter=0;
      power = 1;

      for(int x =i; Math.abs(x)>10; counter++)
      {
        x/=10;
        power = 10*power;
      }
      
      int b=i;//Duplicates number being evaluated

      for(int d = counter;d>=0;d--)
      {
        if(Math.abs(b/power)==9)
          num9++;
        
        b=b-((b/power)*power);
        power/=10;
      }
    }
    return num9;
  }

  public static void main(String[] args)
  {
    System.out.println("Please enter the START of your Range:");
     int start = IO.readInt();//Lower End of the Range

    System.out.println("Please enter the END of your Range:");
      int stop = IO.readInt();//Upper End of the Range

      IO.outputIntAnswer(countLuckyNines(start,stop));
  }


}
