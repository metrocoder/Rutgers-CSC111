//The first $100 has a flat fee of $5.
//Payments over $100 (but under $1000) have a fee of 3% or $6, whichever is higher.
//Payments $1,000 (but under $10,000)  and over have a fee of 1% or $15, whichever is higher.
//Payments $10,000 and over are subject to fees as follows:
//
//  -The first $10,000 have a fee of 1%
//  -The next $5,000 have an additional fee of 2%
//  -Anything more will demand an additional fee of 3%
//-------------------------------------------------------------------------------------------

public class PayFriend
{
  public static void main(String[] args)
  {
    System.out.println("How much would you like to borrow?");
    double loan = IO.readDouble();

    double fee=0;
    if(loan >= 10000)
    {
      if(loan > 15000)
      {
        fee = 100 + 100 + (loan-15000)*.03;
      }
      else if(loan >10000)
      {
        fee = 100 + (loan-10000)*.02;
      }
      else
        fee = 100;
    }
    else if(loan >= 1000)
    {
      fee = loan * .01;

      if(fee <15)
        fee = 15;
    }
    else if(loan > 100)
    {
      fee = loan * .03;

      if(fee <6)
        fee = 6;
    }
    else
    {
      fee = 5;
    }

   //System.out.print(fee);
   IO.outputDoubleAnswer(fee);
  }
}

