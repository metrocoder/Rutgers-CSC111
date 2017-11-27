/*This is just to test how a 3d Array would work so that I can use it for the capstone project
 * The first Dimension would store the #ROW (m) and the second dimension would store the #COL(n)
 * Then the third dimension would be used for the RGB DEC values or HEX(Still debating)
 */

public class 3DarrayTest
{
  public static void main(String[] args) 
  {
    int[][][] arr = new int[2][2][3];

    for(int i = 0; i<arr.length;i++)
    {
      for(int j = 0; j<arr[i].length; j++)
      {
        for(int k = 0; k<arr[i][j].length;k++)
        {
          arr[i][j][k]= (int)(Math.random() * 255+1);
        }
      }
    }
 

    for(int i = 0; i<arr.length;i++)
    {
      System.out.println("Row: "+ i);
      for(int j = 0; j<arr[i].length; j++)
      {
        System.out.println("Column: "+ j);
        for(int k = 0; k<arr[i][j].length;k++)
        {
          System.out.print(arr[i][j][k]);
        }
        System.out.println();
      }
    }

  }//End of Main
}//End of Class
