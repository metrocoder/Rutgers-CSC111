public class Stego
{
  public static void main(String[] args)
  {

    int choice;
    do
    {
      System.out.println("Encrypt you data to an image...\n\n\n\nWhat would you like to encrypt?\n\n\n\nSelect from the following choices:\n\n1 : Text\n2 : Image\n3 : Decrypt\n0: EXIT");
      choice = IO.readInt();
    }while(choice < 0 || choice >3);

    if(choice == 0)
      return;
  /*  
    System.out.println("Please enter the image name (EX: image.png):");
    Path currentRelativePath = Paths.get("");
    String s = currentRelativePath.toAbsolutePath().toString();
    
    String img = IO.readString();

    while(img.length<5)
    {
      System.out.println("*** ERROR***\n\n\nPlease enter the image name (EX: image.png):");
      String img = IO.readString();
    }
  
   
    System.out.println("Please enter the name of your image: ");
    String pic = IO.readString();
    */
    Picture test = new Picture("/home/pi/Documents/CSC111/Capstone/GroundZeroCopy.jpg");// + pic);
    
    Picture testD = new Picture("/tmp/myUpdatedPicture.bmp");// + pic);
    //Picture p = new Picture(s+"/"+img);    
    if(choice == 1)
    {
      System.out.println("Please enter the text:");
      String text = IO.readString();
      
      textToImg(test,text);
    }
    else if(choice == 2)
    {
      //imgToImg(p,q);
    }
    else
      System.out.println(decryptImgTxt(testD));
  }

  /* This method is to embed a txt Message into an image
   */
  public static void textToImg(Picture a, String b)
  {
    int msgLen = 8 * b.length();//Think of a way to use this to limit our embedding into the pic[1 char = 1 byte = 8 bits]
    int[] binText = binstringToInt(charToBin(stringToChar(b)));// The string converted to ONES and ZEROS

    System.out.println("BinText length: Line 55: "+binText.length +"\nCharToBin length: "+ charToBin(stringToChar(b)) +"\nStringToCharArray " + stringToChar(b).length+"\nlength of String input: "+ b.length());
  
  /* Methods I need to use
   *
   * stringToChar() 
   * charToBin()                                  
   * binstringToInt()
   */

    int limit = binText.length;//Length of our String converted to BINARY
    int tracker = 0;


    for(int y = 0; y< a.getHeight();y++)//Go Vertical on the image
    {
      if(tracker + 1 == msgLen)
        break;

      for(int x = 0;x<a.getWidth() ; x++)//Go Horizontal on the image or as long as our mesage is
      {
        if(tracker + 1 == msgLen)
          break;
        Pixel check = a.getPixel(x,y);//Get the Pixel at our (x,y)-Coord

        int[] values;//An empty array to use
        
        if(x == 0 && y == 0)//The first pixel is used to indicate what we are decrypting/encrypting and the length of the embedded data
        {
          values = binstringToInt(Integer.toBinaryString(check.getRed()));//Get the binary value of this then LSB should be 0 = txt, 1 = img;

          if(values[values.length -1] == 1)
            check.setRed(check.getRed()-1);//Set red LSB to 0 to indicate TXT -> IMG
          //-----

          if(binText.length>256)//Since each pixel can hold a value of 0-255 we have 256^2 possible combos
          {
            String length = Integer.toBinaryString(binText.length);//Convert the length of our String array to a string to make it easy to convert to other base

            check.setGreen(Integer.parseInt(length.substring(0,8),2));//This is to set our length from 1 - 256
            check.setBlue(Integer.parseInt(length.substring(8),2));//If the length of our String is > 256 we set this
          }
          else
          {
            check.setBlue(0);//If the length of our String is <= 256 we set this to 0
            check.setGreen(binText.length);//This is to set our length from 1 - 256
          }
        }
        else //This part actually takes our Binary data and embeds it 3 bits at a time.
        {

          //Come up w/ a loop that goes 3 at a time through our binary converted string.

          int[] red = binstringToInt(Integer.toBinaryString(check.getRed()));//Get the binary value of Red;
          int[] blue = binstringToInt(Integer.toBinaryString(check.getBlue()));//Get the binary value of Blue;
          int[] green = binstringToInt(Integer.toBinaryString(check.getGreen()));//Get the binary value of Green;

          for(int l = 0; l<3 ;l++)//Changes our LSB of RGB to 3 bits of our Binary String
          {
            System.out.println("Tracker: "+ tracker + "\n l is: "+ l);
            if(l == 0 && binText[tracker]!=red[red.length -1])
            {
              red[red.length -1] = binText[tracker];
            }
            else if(l == 1 && binText[tracker]!=green[green.length -1])
            {
              green[green.length -1] = binText[tracker];
            }
            else
            {
              if(l == 2 && binText[tracker]!=blue[blue.length -1])
                blue[blue.length -1] = binText[tracker];
            }
            tracker++;//Keeps track how far into our array we are
            if(tracker + 1 == msgLen)
              break;
          }
        }
      }
    }
    if(!a.write("/tmp/myUpdatedPicture.bmp"))
      System.out.println("***Error in writing image***");
  }

  public static String decryptImgTxt(Picture p)
  {
    String decrypted = "";

    int tracker = 0;
    int length = 0;
    int[] stringBin = new int[0];
    
    for(int y = 0; y< p.getHeight() ;y++)//Go Vertical on the image
    {
      for(int x = 0;x<p.getWidth(); x++)//Go Horizontal on the image
      {
        Pixel check = p.getPixel(x,y);//Get the Pixel at our (x,y)-Coord


        if(x == 0 && y == 0)//The first pixel is used to indicate what we are decrypting/encrypting and the length of the embedded data
        {
          if(check.getRed()% 2 == 0 || check.getRed()==0)
          {
            if(check.getGreen()== 0)
            {        
              length = check.getBlue();
            }
            else
            {
             String binString = Integer.toBinaryString(check.getBlue())+ Integer.toBinaryString(check.getGreen()) ;//I need to store this in a larger string
             length = Integer.parseInt(binString,2);//Get length of data fetch
            }
          }        
          System.out.println(length);
        }
        else
        {
          stringBin = new int[length];//Array to store Binary data stored in LSB

          for(int z = 0; z<3 ;z++)
          {
            if(z == 0 )
            {
              if(check.getRed()==1 || check.getRed()%2 != 0)
                stringBin[tracker] = 1;
              else
                stringBin[tracker] = 0;
            }
            else if(z == 1)
            {
              if(check.getGreen()==1 || check.getGreen()%2 != 0)
                stringBin[tracker] = 1;
              else
                stringBin[tracker] = 0;
            }
            else
            {
              if(z == 2)
              {
                if(check.getBlue()==1 || check.getBlue()%2 != 0)
                  stringBin[tracker] = 1;
                else
                  stringBin[tracker] = 0;
              }         
            }
          tracker++;
          if(tracker+1==length)
            break;
          System.out.println(stringBin[tracker]);
          }
        }
      
         if(tracker+1==length)
           break;
      }
       if(tracker+1==length)
         break;
    }
    System.out.println("Length of stringBin Array: "+stringBin.length+"\n Length of binArrayStringFunction: "+ binArrToString(stringBin));
    return binStringToString(binArrToString(stringBin));
  }

  /*This method is used to embed an image into another image
   * (I think one needs to be much bigger than the other)
   * I may not have enough time to get this done
   */
  /*
  public boolean imgToImg(Picture a, Picture b)
  {
  
  }

  */
  /* This method is to convert the message supplied by the user into chars
   * so that it can be easier to convert to bytes (Which is another method)
   */
  public static char[] stringToChar(String a)
  {
    char[] chars = new char[a.length()];//Create an array of the length of our String
    
    for(int i = 0; i<a.length();i++)
    {
      chars[i] = a.charAt(i);//Take the string and store it in our char array
    }
    return chars;
  }

  public static String charToBin(char[] a)
  {
    String binaryConversion = "";
    String zeros = "0";

    for(int i = 0; i< a.length; i++)
    {
      if(Integer.toBinaryString(a[i]).length() < 8)
      { 
        for(int x = 0; x< 8-Integer.toBinaryString(a[i]).length();x++)
        {
          binaryConversion+= zeros;            
        }
      }

      binaryConversion += Integer.toBinaryString(a[i]);
    }

    return binaryConversion;
  }

  public static int[] binstringToInt(String a)
  {
    int[] bins = new int[a.length()];
    for(int i = 0; i< a.length(); i++)
    {
      bins[i] = (a.charAt(i) - 48); //ASCII tricks HOE!!!!Result is 0 or 1
    }

    return bins;
  }

  /* This method is to take the binary array and regroup back into chars/ints
   */
  public static String binArrToString(int[] a)
  {
    String regroup = "";

    for(int x = 0; x<a.length;x++)
    {    
      regroup +=a[x];
    }
  
    return regroup;
  }

  public static String binStringToString(String a)//Convert the Binary String Array to String
  {
    String sent = "";
    for(int x = 0; x< a.length()+16;x+=8)
    {
      System.out.println("Value of x: "+x+"\nThe char produced: "+ a.substring(x,x+8));
      sent += Character.toString((char)Integer.parseInt(a.substring(x,x+8), 2));
    }

    return sent;
  }
}
