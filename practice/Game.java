//Make a text base game using as much as you've read in the java online book
//ARRAYS, LOOPS, EXCEPTIONS, USER-DEFINED FUNCTIONS, String Built-ins, maybe graphics library
//
//Them game is an text-based RPG you start off with 3 lives, you pick a "race"(mage, orc, human, elf), depending on which race they will
//have certain attribute boosters to them, You can level up your skills, think of like castle crashers or that Bathesda game 
import java.util.Scanner;

public class Game
{
  public static void main(String[] args)
  {
  //Ask for the users name
    Scanner keyboard = new Scanner(System.in);

    String hey;
    
    System.out.println("Please enter your name");
    hey = keyboard.next();

    System.out.println(hey);


  }
}
