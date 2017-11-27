public class test2
{
  public static void main(String[] args)
  {
    String hey = IO.readString();

    String a = "";

    while(hey.indexOf(" ") != -1)
    {
      int x = hey.indexOf(" ");

      String fw = hey.substring(0,x);
      a += (char)(hey.charAt(0)-32) + fw.substring(1)+ " ";

      hey = hey.substring(x+1);
    }
  
  System.out.println(a);  
  }
}
