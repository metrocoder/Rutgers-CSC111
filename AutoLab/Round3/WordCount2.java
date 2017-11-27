/*Write your code in the file WordCount.java. Your code should go into a method with the following signature. You may write your own main method to test your code. The graders will ignore your main method:
 *  *
 *   * public static int countWords(String original, int minLength){}
 *    *  
 *     *
 *      *  Your method should count the number of words in the sentence that meet or exceed minLength (in letters). For example, if the minimum length given is 4, your program should only count words that are at least 4 letters long.
 *       *
 *        *  Words will be separated by one or more spaces. Non-letter characters (spaces, punctuation, digits, etc.) may be present, but should not count towards the length of words.
 *         *
 *          *  Hint: write a method that counts the number of letters (and ignores punctuation) in a string that holds a single word without spaces. In your countWords method, break the input string up into words and send each one to your method.
 *           *
 *            */

public class WordCount2
{

    public static int countWords(String original, int minLength)
        {
          
          int letter, x, words, wordLength, totalX, skip;
          String testString = "";//Is to store our substring that is anything between a space
          letter = x = words = wordLength  = totalX = skip = 0;
                   

          while(wordLength + 1 < original.length())//
          {
            while(wordLength +1 < original.length() && original.charAt(wordLength)!= ' ' )//||original.charAt(wordLength)!= '\n' || original.charAt(wordLength)!= '\t' ))
            {
              wordLength++;//get the length of our word that isolated by space tabs or newline
            }
//            while(original.charAt(wordLength)== ' '||original.charAt(wordLength)== '\n' || original.charAt(wordLength)== '\t' )
            while(wordLength +1 < original.length() &&(Character.toLowerCase(original.charAt(wordLength)) < 'a' || Character.toLowerCase(original.charAt(wordLength)) > 'z'))
            {
              wordLength++;
            }

            if(wordLength == original.length()-1)
              wordLength++;
                          

            testString = original.substring(totalX, wordLength);//Put the substring in a variable

            for(x = 0;x < testString.length();x++)//Loop through that substring to count the letters in that word
            {
              if(Character.toLowerCase(testString.charAt(x)) >= 'a' && Character.toLowerCase(testString.charAt(x)) <= 'z')//Counts letters in a substring
                letter++;
            }
            totalX += x;
                                          
            if(letter >= minLength)
              words++;

            letter = 0;   
          }       
           
          return words;
        }

      public static void main(String[] args)
      {
        System.out.println("Enter a string");
        String ha = IO.readString();
        
        System.out.println("Enter a length of words");
        int length = IO.readInt();        
                            
        System.out.println(countWords(ha, length));

      }
}

