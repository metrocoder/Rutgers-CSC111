public class MultiplicationTable
{
  public static void main(String[] args)
  {
    System.out.print("Please enter the Multiplication Table you would like to see");
    int num = IO.readInt();
    printTable(num);

  }
    public static void printTable(int a)
    {
      for(int i=1; i<=a; i++)
      {
        for(int x = 1; x<=a; x++)
        {
          System.out.print(x*i + "\t");
        }
        System.out.println();
      }
    }

  
}
