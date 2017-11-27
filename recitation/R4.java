public class R4
{
  public static void main(String[] args)
  {
    System.out.println("Enter your age");
    int age = IO.readInt();
    
    if(age >= 18)
    {
      System.out.println("You are allowed to vote!");
    }
    else
      System.out.println("You are NOT allowed to vote!");
  }
}
