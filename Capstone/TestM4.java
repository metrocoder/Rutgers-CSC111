public class TestM4
{
  public static void main(String[] args)
  {

    /*TESTS
     * 1) equals // BOOLEAN
     * 2) toString // Returns PICTURE, so i need to save it inside my method
     * 3) negative // Should have a save inside of method call to see results in /tmp
     * 4) redness // return DOUBLE
     * 5) flips // VOID functions
     */

    String testFile = "/home/pi/Documents/CSC111/Capstone/GroundZeroCopy.jpg";
    String desc = "WOW this is really Stupid!!!!";


    String descDiff = "Bitch ass!";
    String failFile = "/home/pi/Documents/CSC111/Capstone/mcSquared.png";



    /* These two objects should test okay
     */

    MyPicture t1 = new MyPicture(testFile, desc);
    MyPicture t2 = new MyPicture(testFile, desc);


    /* Shit that makes the method MyPicture FAIL
     */


    MyPicture t3 = new MyPicture(testFile, descDiff);
    MyPicture t4 = new MyPicture(failFile, desc);

    //Test toString Method
    
    System.out.println("Test toString() for t1: "+ t1.toString());
    System.out.println("Test toString() for t3: "+ t3.toString());
    System.out.println("Test toString() for t4: "+ t4.toString());

    //Test that equals TRUE and TRUE == TRUE

    System.out.println("This is Test,  t1.equals(t2), that equals TRUE == TRUE " + t1.equals(t2));
    System.out.println("This is Test, t2.equals(t1), that equals TRUE == TRUE " + t2.equals(t1));
    

    //Test that equals FALSE == FALSE

    System.out.println("This is Test, t1.equals(t3), that equals FALSE == FALSE: Different DESCRIPTIONS " + t1.equals(t3));//Different DESCRIPTIONS
    System.out.println("This is Test,  t1.equals(t4), that equals FALSE == FALSE: /Different FILENAME " + t1.equals(t4));//Different FILENAME

    System.out.println("This is Test, t3.equals(t1), that equals FALSE == FALSE: " + t3.equals(t1));//
    System.out.println("This is Test, t4.equals(t1), that equals FALSE == FALSE: " + t4.equals(t1));//

    //---------------------------
    //

    System.out.println("This is the REDNESS test for t1 "+ t1.redness());//Redness test
    System.out.println("This is the REDNESS test for t4 "+ t4.redness());//Redness test

    //t1.flipVertical();
    //t1.flipHorizontal();

//    t2.flipHorizontal();
//    t2.flipVerical();

    t3.negative().write("/tmp/n.jpg");

    System.out.println("This is the end of the TEST. Check your /tmp directory for the images saved as a test");
  }
}
