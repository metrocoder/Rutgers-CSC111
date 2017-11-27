//1) The number of people attending
//2) How many slice of Pizza each person should have to eat
//3) The number of cans of sodas each person should have to drink
//4) The cost of the Pizza pie
//5) The number of slices in a pizza pie
//6) The cost of a case of soda
//7) The number of cans of soda in a case of soda
//-----------------------------------------------------------------

public class Party
{
  public static void main(String[] args)
  {
    System.out.println("How many people will be attending the event?");
    int numPpl = IO.readInt(); // To get the number of people attending
    //while(numPpl <=0)
    //{
    //  System.out.println("\n\n\n\n***ERROR***\n\n\n\nHow many people will be attending the event?");
    //  int numPpl = IO.readInt();
    //}
    
    System.out.println("How many slice of Pizza each person should have to eat?");
    int numSlice = IO.readInt();//To get number of slices per person
    //while(numSlice <=0)
    //{
    //  System.out.println("\n\n\n\n***ERROR***\n\n\n\nHow many slice of Pizza each person should have to eat?");
    //  int numPpl = IO.readInt();
    //}

    System.out.println("The number of cans of sodas each person should have to drink?");
    int numCans = IO.readInt(); //To get cans of soda per person
    //while(numCans <=0)
    //{ 
    //  System.out.println("\n\n\n\n***ERROR***\n\n\n\nThe number of cans of sodas each person should have to drink?");
    //  int numCans = IO.readInt();
    //}
  
    System.out.println("The cost of the Pizza pie:");
    double costPie = IO.readDouble(); //To get price of a pie of pizza
    //while(costPie <=0)
    //{ 
    //  System.out.println("\n\n\n\n***ERROR***\n\n\n\nThe cost of the Pizza pie:");
    //  int costPie = IO.readInt();
    //}

    System.out.println("The number of slices in a pizza pie:");
    int slicesPerPie = IO.readInt(); //To get # slices per pie of pizza

    //while(slicePerPie <=0)
    //{ 
    //  System.out.println("\n\n\n\n***ERROR***\n\n\n\nThe number of slices in a pizza pie:");
    //  int slicesPerPie = IO.readInt(); //To get # of slices per pie of pizza
    //}
    
    System.out.println("The cost of a case of soda:");
    double costSoda = IO.readDouble();
   
    //while(costSoda <=0)
    //{ 
    //  System.out.println("\n\n\n\n***ERROR***\n\n\n\nThe cost of a case of soda:");
    //  int costSoda = IO.readInt();
    //}
    
    
    System.out.println("The number of cans of soda in a case of soda");
    int cansPerCase = IO.readInt();
   
    //while(cansPerCase <=0)
    //{ 
    //  System.out.println("\n\n\n\n***ERROR***\n\n\n\nThe number of cans of soda in a case of soda");
    //  int cansPerCase = IO.readInt();
    //}

    int remainder, sodaRemainder;
    double totalPizza, totalSoda;
    remainder = (numPpl*numSlice)%slicesPerPie;
    sodaRemainder = (numPpl*numCans)%cansPerCase;

    //-----------Calculate For Pizza-----------
    if(remainder > 0)
    {
      totalPizza= ((((numPpl*numSlice)/slicesPerPie)+1)*costPie);
    }
    else
    {
      totalPizza= (((numPpl*numSlice)/slicesPerPie)*costPie);
    }
    

    //-----------Calculate For Soda-----------
    if(sodaRemainder > 0)
    {
      totalSoda= ((((numPpl*numCans)/cansPerCase)+1)*costSoda);
    }
    else
    {
      totalSoda= (((numPpl*numCans)/cansPerCase)*costSoda);
    }

    //System.out.println("\n\n\nTotal for pizza: "+ totalPizza + "\n\n\nTotal for Soda: " + totalSoda +"Grand Total = " + (totalSoda+totalPizza));
    IO.outputDoubleAnswer(totalSoda+totalPizza);
  }
}

