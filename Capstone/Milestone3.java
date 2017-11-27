public class Milestone3
{
     /*
      *    * Returns the number of red pixels in a picture
      *       * Unlike true red. This really checks every variation of red
      *          */

    public static int myCountRedPixels(Picture v)
        {
              int count = 0;

                  for(int y = 0;y <v.getHeight();y++)
                        {
                                for(int x = 0; x < v.getWidth();x++)
                                        {
                                                  Pixel check = v.getPixel(x,y);

                                                          if(check.getRed()>check.getBlue() && check.getRed()>check.getGreen())
                                                                      count++;
                                                                }
                                    }
                    
                      return count;
                        }
      /* This switches every singles blue with red
       *   *
       *     *
       *       */
      public static void mySwitchRedBlue(Picture v)
          {
                for(int y = 0;y <v.getHeight();y++)
                      {
                              for(int x = 0; x < v.getWidth();x++)
                                      {
                                                Pixel check = v.getPixel(x,y),temp;
                                                        temp = check;

                                                                temp.setBlue(check.getBlue());
                                                                        check.setBlue(check.getRed());
                                                                                check.setRed(temp.getBlue());
                                                                                      }
                                  }


                    if(!v.write("/tmp/mySwitchRedBlue.jpg"))
                            System.out.println("***Error in writing image***");
                     
                      }


        /* Converts an image to GREYSCALE by using Luminosity Method
         *    */

        public static void greyScale(Picture v)
            {
                  for(int y = 0;y <v.getHeight();y++)
                        {
                                for(int x = 0; x < v.getWidth();x++)
                                        {
                                                  Pixel check = v.getPixel(x,y),temp;
                                                          temp = check;

                                                                  int grey = (int)(0.07 *check.getBlue())+(int)(0.72 * check.getGreen()) +(int)(0.21 * check.getRed());
                                                                          check.setBlue(grey);
                                                                                  check.setRed(grey);
                                                                                          check.setGreen(grey);
                                                                                                }
                                    }


                      if(!v.write("/tmp/greyScale.jpg"))
                              System.out.println("***Error in writing image***");
                        } 
          
          public static void main(String[] args)
              {
                 
                    Picture test = new Picture("/home/pi/Documents/CSC111/Capstone/GroundZeroCopy.jpg");

//    System.out.println("Please enter the PATH and name of your image: ");
  //      String pic = IO.readString();
    //        Picture test = new Picture(pic);
               
                    System.out.println(myCountRedPixels(test));

                        mySwitchRedBlue(test);
                            greyScale(test);
                                
                                  }
                                  }
