public class R4b
{
  public static void main(String[] args)
  {
    System.out.println("Enter the Speed in MPH:");
    int speed = IO.readInt();
    int fine;
   
    if(speed > 90)
    {
      fine = 500;
    }
    else if(speed > 75)
    {
      fine = 200;
    }
    else if(speed > 60)
    {
      fine = 100;
    }
    else
      fine = 0;

    System.out.println("Your fine is" + fine);
  }
}
