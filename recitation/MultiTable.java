public class MultiTable
{
  public static void main(String[] args)
  {
    System.out.println("Please enter a number to see it Multiplication Table");
    int input = IO.readInt();

    for(int y = 1; y<=input; y++)
    {
      for(int x = 1; x<=input;x++)
      {
        System.out.print(x*y+"\t");
      }
      System.out.println();
    }

    System.out.println("\n\n\n\n\nThank you!");
  }
}
