//Write a program called SmallestLargest.java which outputs the biggest and smallest numbers in a list of numbers entered by the user. 
//Ask the user for a terminating value which should be entered again when they are done inputting the list of numbers. 
//First output the smallest number and then the biggest number.
//There must be at least 1 number in the list. 
//YOU MUST USE THE IO MODULE FOR INPUT/OUTPUT. 
//Report bad input via IO.reportBadInput() and exit on error.

public class SmallestLargest
{
  public static void main(String[] args)
  {
    double max=0, min=0, in;
    System.out.println("Please enter your start/stop number:");
    double startStop = IO.readDouble();//Number to stop the input
    int count=0;
     do
     {
       System.out.println("Start entring your numbers:");
       in = IO.readDouble();
       count++; 
      
       if(count==1 && in!=startStop)
       {
         max = in;
         min = in;
       }

       if(count!=1 && in!=startStop)
       {
         max = Math.max(in,max);
         min = Math.min(in,min);
       }

     }while(in!=startStop);//Recieves input as long as they dont put the startStop num in

    if(in==startStop && count==1)//If they never entered at least one number or it matched startStop
    {
      IO.reportBadInput();
      return;
    }
    
    IO.outputDoubleAnswer(min);
    IO.outputDoubleAnswer(max);
  }
}
