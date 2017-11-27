/*Write your code in the file Compress.java. Your code should go into a method with the following signature. You may write your own main method to test your code. The graders will ignore your main method:
 *
 *    public static String compress (String original){}
 *    
 *
 *    Run-length encoding (RLE) is a simple "compression algorithm" (an algorithm which takes a block of data and reduces its size, producing a block that contains the same information in less space). It works by replacing repetitive sequences of identical data items with short "tokens" that represent entire sequences. Applying RLE to a string involves finding sequences in the string where the same character repeats. Each such sequence should be replaced by a "token" consisting of:
 *
 *    the number of characters in the sequence
 *    the repeating character
 *    If a character does not repeat, it should be left alone.
 */

public class Compress//You can use a substring to make it contain the string with a particular char/String.
{
    public static String compress(String original)
    {
      char check;
      int i;
      String checkString = "", finalString = "";


      for(int x = 0 ; x < original.length() ; x+=i)
      {

        i = 0; // initilize variable i    
        
        check = original.charAt(x);//copy the value at x position in string
        checkString = original.substring(x);
    
        while(checkString.length()>i && check == checkString.charAt(i))//see how many copies of that value exist and count them
        {
          i++;
        }   

        if(i == 1)
          finalString += original.substring(x,x+1); 
        else
          finalString += i + original.substring(x,x+1);
      }

      return finalString;
    }

      
      
    public static void main(String[] args)
    {

      System.out.println("Please enter a string that should be compressed");
      String in = IO.readString();                       

      System.out.println(compress(in));
    }
        
}
