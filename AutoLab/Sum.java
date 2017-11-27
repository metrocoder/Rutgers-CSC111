//Write your code in a file called Sum.java. Use the IO module to read inputs and output answers.
//Ask for 2 numbers (integers) from the user. Print out the sum of the two numbers.
//
public class Sum
{
  public static void main(String[] args)
  {
    int cont;
    do
    {
      System.out.print("Please enter the first number:");
      int num1 = IO.readInt();

      System.out.print("Please enter the second number:");
      int num2 = IO.readInt();


      System.out.println("----------\n");
      IO.outputIntAnswer(num1+num2);
      System.out.println("\n----------");
      
      System.out.println("\n\n\n\n\nWould you like to use the program again?\n1) YES\n2) NO");
      cont = IO.readInt();

      while(cont != 1 && cont != 2)
      {
        System.out.println("\n\n\n\n\n***ERROR***\n\n\n\nWould you like to use the program again?\n1) YES\n2) NO\n\n\n\n");
        cont = IO.readInt();
      }

    }while(cont == 1);
  }
}
