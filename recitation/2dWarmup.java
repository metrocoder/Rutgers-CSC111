public class 2dWarmup{

  public static void main(String[] args)
  {
    int[][] matrix = { (0,1,2), (3,4,5), (6,7,8)}
  }


  public static int warm(int in[][])
  {
    int countZERO, countONE;
    countZERO = countONE =0;
 
    for(int y = 0;y<in.length;y++)
    {
      for(int x = 0;x<in[y].length; x++)
      {
        if(in[y][x]==0)
          counteZERO++;
        else
          if(in[y][x]==1)
            countONE++;
      }
    }
  }


}
