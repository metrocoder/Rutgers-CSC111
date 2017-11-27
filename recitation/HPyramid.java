public class HPyramid
{
  public static void main(String[] args)
  {
    System.out.println("Please enter the height of your pyramid:");
    int height = IO.readInt();

    for(int i = 1; i <= height; i++)//Go a "HEIGHT" on Y-Axis
    {
     // System.out.print(i);
      for(int y= 0; y<i; y++)//How many stars to print in X-Axis
      {
       //  System.out.print(y);
        System.out.print("*");
      }

      System.out.print("\n");
    }

    for(int x = 1; x<height;x++)//Start at 1 and move our way On Y-Axis
    {
     //  System.out.print(x);
      for(int y= height-x ; y>0; y--)//Go in X-Axis
      {
       //  System.out.print(y);
        System.out.print("*");
      }
     System.out.print("\n"); 
    }
  }
}
