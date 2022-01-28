// Path absolute path and 
// Read write from string/buffer
// Fundamental unit of HDD is byte

// String and Buffer

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Driver{
  public static void main(String[] args) throws Exception{
    FileInputStream fis = new FileInputStream("C:/Users/Administrator/Documents/Java/File Handling/testfile.txt");
    int ch;

    while((ch = fis.read()) != -1){
      System.out.print((char)ch);
    }
    fis.close();

    
    FileOutputStream fos = new FileOutputStream("C:/Users/Administrator/Documents/Java/File Handling/testfile.txt");
    fos.write('h');
    fos.close();

    System.out.println("\nExited.");
  }
}