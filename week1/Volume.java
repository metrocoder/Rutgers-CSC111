public class Volume{
	public static void main(String[] args){
		
		System.out.println("Please enter radius");
		double radius = IO.readDouble();

		double volume = (((4.0/3.0)*3.14159)*(radius * radius * radius));

		System.out.println(volume);

		

	}

}

