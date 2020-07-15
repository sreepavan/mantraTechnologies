import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
public class Q1 {
	public static void main(String[] args) {
	    try { 
	      char[] array = new char[1000];
	      FileReader input1 = new FileReader("newFile1.txt");
	      FileReader input2 = new FileReader("newFile2.txt");
	      
	      input1.read(array);
	      System.out.println("Data in the file1:");
	      System.out.println(array);
	      input1.close();
	    }
	    catch(Exception e) {
	      e.getStackTrace();
	    }
	 
	}
}
