public class VPyramid
{
  public static void main(String[] args)
  {
    System.out.println("Please Enter the height of the Pyramid");
    int height = IO.readInt();//Get height of pyramid

    int count=1, looper = height;

    while(looper!=0)//Pyramid Height by layer
    {
      for(int x =1;x<height;x++)//Print out blank spaces from left
      {
        System.out.print(" ");
      }

      for(int z =1;z<=count;z++)//Print out star to make up pyramid body
      {
        System.out.print("*");
      }
      
      System.out.println();//End layer

      //Prep next layer
      count+=2;//Increase fill of the Pyramid
      height--;//To accomodate for the wider Pyramid
      looper--;//Move on to next layer of Pyramid
    }
  }
}
