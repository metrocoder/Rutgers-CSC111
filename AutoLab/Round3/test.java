public class test
{
  public static void main(String[] args)
  {
    String test = IO.readString();
    

    String append = "";
    append += (char)(test.charAt(0)-32 )+ test.substring(1);

    System.out.println(append);
  }
}
