/* Multiply matrices A and B. 
 * Return the product matrix. 
 * This method must work for matrices of any size (i.e., with any number of rows and/or columns). 
 * Treat "rows" as the first dimension and "columns" as the second dimension. 
 * Return null if the matrices cannot be multiplied. 
 */

public class MatrixOps
{
  public static double[][] multiply(double[][] A, double[][] B)
  {
    
    if(A[0].length != B.length && B[0].length != A.length)//|| A==null || B==null)//If an M x N matrix is multiplied with !N x P
    {
      return null;
    }
    //---This section is to check that the matrix have equal length rows---
    int checkA = 0;
    for(int x = 0;x<A.length;x++)
    {
      checkA += A[x].length;
    }
    
    int checkB = 0;
    for(int x = 0;x<B.length;x++)
    {
      checkB += B[x].length;
    }

    if(checkA/A.length != A[0].length || checkB/B.length != B[0].length)
      return null;
    
    //---End of Row Check---
   


    double[][] multi = new double[A.length][B[0].length];//Create an M x P Matrix
    
    
    for(int i = 0;i<B[0].length;i++)
    {
      for(int y = 0; y<A.length;y++)
      {
        for(int x = 0; x<A[y].length; x++)
        {
          multi[y][i]+=A[y][x] * B[x][i];
        }
      }
    }

    return multi;
  }
  
  
  public static void main(String[] args)
  {
  
  }
}
