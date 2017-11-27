public class FinalPrep
{
  public static void main(String[] args)
  {
  
    String[] arr = {"A","B","Z","H","I", "M", "R","E"};
    String find = "Z";

    int[] l = {1,2,4,8,20};

    int c = 1;

    arr = sortString(arr);

    for(int x = 0; x<arr.length;x++)//To print out the elements in the sorted array
    {
    
      System.out.println(arr[x]);
    }

    System.out.println(binarySearch(l,c));

  }    
    public static String[] sortString(String[] a) //Insertion Sort method
    {
      String temp = "";
    
      for(int x = 1;x<a.length; x++)
      {
        for(int nx = x; nx>0;nx--)
        {
          if(a[nx].compareTo(a[nx - 1]) < 0 )
          {
            temp = a[nx - 1] + Integer.toString(a[nx].compareTo(a[nx - 1]));
            a[nx - 1] = a[nx];
            a[nx] = temp;
          }
          else
            break;
        }
      }
      return a;
  
    }

    public static int binarySearch(int[] a, int t) //Binary Search
    {
     int mid, end = a.length - 1,start = 0;
      
      while(start <= end)
      {
        mid = (end + start)/2;
        
        if(a[mid] == t)
          return mid;
        else if(a[mid] > t)
          end  = mid - 1;
        else
          start = mid + 1;
      }
      return -1;     
    }
}
