public class StringRec
{
  public static String decompress(String compressedText)
  {

    if(compressedText.length() == 0)
      return "";//Return the letter at that index

    if(compressedText.length() == 1)
      return compressedText.substring(0);

    if(compressedText.charAt(0) >= '1' && compressedText.charAt(0) <= '9')
    {
      if(compressedText.charAt(0)-1 == '0')
        return decompress(compressedText.substring(1));
      else
        return compressedText.substring(1,2) + decompress(Integer.toString(compressedText.charAt(0) - '1') + compressedText.substring(1)); 
    }
  
    return compressedText.substring(0,1) + decompress(compressedText.substring(1));//Return the letter at that index
  }
}
