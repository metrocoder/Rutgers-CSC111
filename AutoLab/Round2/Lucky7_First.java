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
    int start = IO.readInt();

    System.out.println("Please enter the END of your Range:");
    int stop = IO.readInt();

    if(stop<start)
      return;

//    if(stop-start<7)
//      IO.outputIntAnswer(0);
//    else if(stop-start==7)
//      IO.outputIntAnswer(1);
//    else
//      IO.outputIntAnswer((stop-start)/10);

//    int bullshit = stop-start, answer;
//    for(int count = 0;count<stop-start;count++)
//    {
//      if(bullshit <7)
//        answer = 0;break;
//      else if(7-start ==7)
//        answer =1;break;
//      else
//        answer = bullshit/10;
//    }

    int count=0, num7=0;
//    for(int x=stop-start;x>10;count++)
//    {
//      x/=10;
//    }
//
//    System.out.println(count);

    int counter, power;
    for(int i = start; i <= stop; i++)
    {
      counter=0;
      power = 1;

      System.out.println("I "+i);
      System.out.println("Num 7 "+num7);

      for(int x =i; x>10; counter++)
      {
        x/=10;
        power = 10*power;
      }
//      System.out.println("Counter "+counter);
      int b=i;

      for(int d = counter;d>=0;d--)
      {

        if(b/power==7)
          num7++;

        b=b-((b/power)*power);
        power/=10;

/*        for(int x = d; x>=0;x--)
        {
          if(x)
          power = 10*x;
        }
        
          if(d==1&& b/10==7)
            num7++;
          else
          {
            if(b/(Math.pow(10,d) * 7)==1)
              num7++;
          }
//          if(b/(Math.pow(10,d) * 7)==1 && d >1)
//          else if(x ==1 && b/10==7)
//            num7++;
//          else if(b/(Math.pow(10,d) * 7)==1 && d >1)
//            num7++;
        if(d == 1)
          b= b - ((b/10)*10);
        else
          b = b - (int)((b/Math.pow(10,d))*Math.pow(10,d));
*/        
        System.out.println("B "+b+" /" + ((b/Math.pow(10,d))*Math.pow(10,d))+" d "+d);
      }
      
/*      for(int c=i;c>10;counter++)
      {
        c/=10;
      }
      for(int y=0;y<=counter;y++)
      {
        if(i/Math.pow(10,y)==7) //|| ((i%Math.pow(10,y))%7==0&& i>10))
        {
          num7++;

          if(i>10 && y>0)
          {
            if((i%Math.pow(10,y))!=0)// && (i%Math.pow(10,y))%7==0)
            {
              if((i%Math.pow(10,y))/7==1 ||((i%Math.pow(10,y))/7)%11 == 0 || ((i%Math.pow(10,y))/7)%11 == 1||(i%Math.pow(10,y))/7==10)
                num7++;
            }
          }
        }
        else 
        {
          if(i>10 && y>0)
          {
            if((i%Math.pow(10,y))!=0)// && (i%Math.pow(10,y))%7==0)
            {
              if((i%Math.pow(10,y))/7==1 ||((i%Math.pow(10,y))/7)%11 == 0 || ((i%Math.pow(10,y))/7)%11 == 1 || (i%Math.pow(10,y))/7==10)
              {
                num7++;
              }
            }
          }
        }
      } 
*/    }
    IO.outputIntAnswer(num7);
  }
}
