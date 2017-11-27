/*Write your code in the file PigLatin.java. Your code should go into a method with the following signature. You may write your own main method to test your code. The graders will ignore your main method:
 *
 * public static String translate (String original){}
 *
 * "Pig Latin" is a fake language used as a children's game. A word in English is "translated" into Pig Latin using the following rules:
 *
 * If the English word begins with a consonant, move the consonant to the end of the word and add "ay". The letter Y should be considered a consonant.
 * If the English word begins with a vowel (A, E, I, O, or U), simply add "way" to the end of the word.
 * (This is a simplified dialect of Pig Latin, of course.)
 *
 * Write your method so that it returns the pig latin translated original string. You may assume that the input does not contain digits, punctuation, or spaces. The input may be in any combination of uppercase or lowercase. The case of your output does not matter.
 */

public class PigLatin
{
  /* This is the function that will take our String and convert it to 
   * it PIGLATIN version
   */

  public static String translate(String original)
  {
    int x = 0, y, isVowel=0;// a= 'a', i = 'i', o = 'o', u = 'u';
    int[] vowels = { 'a','e','i','o', 'u'};//ARRAY of vowels to check for

    char l = original.charAt(x);

    y =  0;//Initialize vowels checker
      
      while(y<vowels.length)//LOOP that checks the vowel against the char that were at in the STRING
      {
        if(Character.toLowerCase(l) == vowels[y])
        {
          isVowel = 1;
          y = vowels.length;
        }
        y++;
      }

  
      if(isVowel == 1)
      {
        return original + "way";
      }
  
      return original.substring(1) +original.substring(0,1)+"ay";
  }


  public static void main(String[] args)
  {
     String blah = IO.readString();

     System.out.print(translate(blah));
  }
}
