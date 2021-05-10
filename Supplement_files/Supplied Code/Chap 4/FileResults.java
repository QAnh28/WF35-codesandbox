import java.io.*;
import java.util.*;

public class FileResults
{
   private static final long REC_SIZE = 34;
   private static final int SURNAME_SIZE = 15;
   private static String surname;
   private static int mark;

   public static void main(String[] args)
						throws IOException
   {
	/**********************************************
            *** SUPPLY CODE FOR main! ***
	**********************************************/
   }

   public static void writeString(
			RandomAccessFile file, String text,
			int fixedSize) throws IOException
   {
      int size = text.length();

      if (size<=fixedSize)
      {
         file.writeChars(text);
         for (int i=size; i<fixedSize; i++)
            file.writeChar(' ');
      }
      else
         file.writeChars(text.substring(
						0,fixedSize));
   }

   public static String readString(
			RandomAccessFile file, int fixedSize)
		  throws IOException
   {
      String value = "";
      for (int i=0; i<fixedSize; i++)
         value+=file.readChar();
      return value;
   }
}
