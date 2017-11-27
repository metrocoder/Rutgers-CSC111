//We wish to write a program that takes a set of numbers and determines which are the two smallest.
//
//Ask the user for the following information, in this order:
//
//A terminating value (real number). The user will enter this value again later, to indicate that he or she is finished providing input.
//A sequence of real numbers. Keep asking for numbers until the terminating value is entered.
//Compute and output the smallest and second-smallest real number, in that order. It is possible for the smallest and second-smallest numbers to be the same (if the sequence contains duplicate numbers).
//
//
public class TwoSmallest
{
  public static void main(String[] args)
  {
    double min1=0, min=0, in;
    System.out.println("Please enter your start/stop number:");
    double startStop = IO.readDouble();//Number to stop the input
    int count;
    do
    {
      count = 0;
      do
      {
        System.out.println("Start entring your numbers:");
        in = IO.readDouble();
        count++;

        if(count==1 && in!=startStop)
        {
          min1 = in;
          min = in;
        }

        if(count!=1 && in!=startStop)
        {
          if(min>in)
          {
            if(min<min1)
              min1 = min;

            min = in;
          }
          else
          {
            if(min1>in||count==2)
              min1 = in;
          }  
        }
      }while(in!=startStop);//Recieves input as long as they dont put the startStop num in
    
      if(in==startStop && count<=2)System.out.print("***ERROR***\nTRY AGAIN\n\n\n");    
    }while(in==startStop && count<=2);//If they never entered at least one number or it matched startStop

    IO.outputDoubleAnswer(min);
    IO.outputDoubleAnswer(min1);
  }
}
