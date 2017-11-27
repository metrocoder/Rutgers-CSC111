public class Ohms
{
	public static void main(String[] args)
	{
	  //Start
      System.out.println("Hello!!\nThis Program allows you to calculate the Ohm Value for a resistor.");
      
      //Variables
      int band1, band2, band3;
      
      //Ask For Input w/ Validity Checking loop
      System.out.println("Select from the following for the FIRST band\n1) Black\n2) Brown\n3) Red\n4) Orange\n5) Yellow\n6) Green");
      band1 = IO.readInt();
      if(band1 < 1 || band1 > 6)
      {
        while(band1 < 1 || band1 > 6)
        {
           System.out.println("*** Error! ***\n\n\nSelect from the following for the FIRST band\n1) Black\n2) Brown\n3) Red\n4) Orange\n5) Yellow\n6) Green");
           band1 = IO.readInt();
        }
      }

      System.out.println("Select from the following for the SECOND band\n1) Black\n2) Brown\n3) Red\n4) Orange\n5) Yellow\n6) Green");
      band2 = IO.readInt();
      if(band2 < 1 || band2 > 6)
      {
        while(band2 < 1 || band2 > 6)
        {
          System.out.println("*** Error! ***\n\n\nSelect from the following for the SECOND band\n1) Black\n2) Brown\n3) Red\n4) Orange\n5) Yellow\n6) Green");
          band2 = IO.readInt();
        }
      }

      System.out.println("Select from the following for the THIRD band\n1) Black\n2) Brown\n3) Red\n4) Orange\n5) Yellow\n6) Green");
      band3 = IO.readInt();
      if(band3 < 1 || band3 > 6)
      {
        while(band3 < 1 || band3 > 6)
        {
          System.out.println("*** Error! ***\n\n\nSelect from the following for the THIRD band\n1) Black\n2) Brown\n3) Red\n4) Orange\n5) Yellow\n6) Green");
          band3 = IO.readInt();
        }
      }
      //---------- End of Inputs from User -----------//
      //
      //
      //This is fucking bullshit because built-in functions are not allowed
      
      if ((((band1-1)*10)+band2-1)==0)
      {
        System.out.println("Not Valid!");
        return;
      }

      int band3pow= 1;
      for(int i= 1;i <band3; i++)
      {
        band3pow*=10;
      };

      //Output Ohms of 3 Band Resistor//
      //System.out.println("The Total Ohms for this resister is: "+ String.format("%,d",(((band1-1)*10)+band2-1) * (int)Math.pow(10, band3-1))+" Ohms");
      System.out.println("The Total Ohms for this resistor is: "+ String.format("%,d",(((band1-1)*10)+band2-1) * band3pow)+" Ohms");
	}
}
