public class Volume1{
	public static void main(String[] args){
		
		System.out.println("Please enter radius");
		double radius = IO.readDouble();

		if (radius <= 0)
		{
			do
			{
				System.out.println("Error!\nPlease enter a valid value");
				radius = IO.readDouble();
			}while(radius <=0);
		}

		double volume = (((4.0/3.0)*3.14159)*(radius * radius * radius));

		//System.out.println(volume);
		IO.outputDoubleAnswer(volume);
		

	}

}

