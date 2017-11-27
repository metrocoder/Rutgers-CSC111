public class MyPicture
{

  private String filename;
  private String description;
  private Picture img;

/* Constructor. Takes as a parameter, the name of the file
 * to load and a description of the picture
 */
public MyPicture(String filename, String description) 
{
  this.filename = filename;
  this.description = description;
  img = new Picture(filename);
}

/* Returns the string representation for a MyPicture object.
 * The string’s format should match the following EXACTLY.
 * <imagename>.<extension> <width> x <length> <description>
 * Replace <xxx> with the respective data about this image
 */

public String toString()
{
  //String ext, name;
  //ext = filename.substring(filename.lastIndexOf(".") + 1,filename.length());
  
  //name = filename.substring( filename.lastIndexOf("\\") + 1 , filename.lastIndexOf("."));
  
  //if(name.length() == (filename.length() - (ext.length() + 1)))
    //name = filename.substring(filename.lastIndexOf("/") + 1 , filename.lastIndexOf("."));

  //return name +"."+ext+" "+img.getWidth() + " x "+ img.getHeight() +" "+ description;

  return filename + " " + img.getWidth() + " x "+ img.getHeight() + " " + description;
}

/* Returns true of the parameter MyPicture object is equal 
 * to the current instance, false otherwise. MyPicture
 * objects are considered equal if and only if their
 * filenames are the same AND their descriptions are the
 * same.
 */

public boolean equals(MyPicture p) 
{
  if(this.filename == p.filename && this.description == p.description)
    return true;

  return false;
}

/* Returns a new Picture object representing the ‘negative’
 * image of this MyPicture object. The negative of a pixel
 * is defined by taking each pixel’s red, blue, and green value and
 * subtracting that value from 255.
 */

public Picture negative()
{
  Picture neg = new Picture(img.getWidth(),img.getHeight());
  
  for(int y=0;y<neg.getHeight();y++)
  {
    for(int x = 0; x<neg.getWidth();x++)
    {
      Pixel p = img.getPixel(x,y);
      Pixel pn = neg.getPixel(x,y);

      int r = p.getRed(), g= p.getGreen(), b= p.getBlue();
      pn.setRed(255 - r);
      pn.setGreen(255 - g);
      pn.setBlue(255 - b);
    }
  } 
    
  return neg;
}

/* Returns the redness score of this image. The redness
 * score is defined by the total number of pixels that have
 * a red value that is greater than both the blue and green
 * pixels divided by the total number of pixels
 */
public double redness() 
{
  
  int count = 0;

   for(int y = 0;y <img.getHeight();y++)
   {
     for(int x = 0; x < img.getWidth();x++)
     {
       Pixel check = img.getPixel(x,y);
       
       if(check.getRed()>check.getBlue() && check.getRed()>check.getGreen())
         count++;
     }
   }
   return (double)count/(img.getHeight()*img.getWidth());
}

/* Lastly, convert flipHorizontal and flipVertical to instance methods:
 */

public void flipHorizontal() 
{

  for(int y = 0;y <img.getHeight();y++)
  {
    for(int x = 0; x < img.getWidth()/2;x++)
    {
      Pixel check = img.getPixel(x,y),temp = img.getPixel(img.getWidth() - (x+1),y);

      temp.setBlue(check.getBlue());
      temp.setRed(check.getRed());
      temp.setGreen(check.getGreen());
    }
  }
    
    //img.write("/tmp/flipHorizontalMyPicture.jpg");
}

public void flipVertical()
{

  for(int y = 0;y <img.getHeight()/2;y++)
  {
    for(int x = 0; x < img.getWidth();x++)
    {
      Pixel check = img.getPixel(x,y),temp = img.getPixel(x,img.getHeight()-(1+y));

      temp.setBlue(check.getBlue());
      temp.setRed(check.getRed());
      temp.setGreen(check.getGreen());
    }
  }

    //img.write("/tmp/flipVerticalMyPicture.jpg");
}
}
