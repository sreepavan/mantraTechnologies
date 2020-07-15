import java.awt.RenderingHints.Key;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import javax.xml.crypto.Data;

public class Q2 {

	public static void main(String[] args) {
		try { 
	      FileReader input1 = new FileReader("newFile.csv");
	      int key = 0;
	      try (BufferedReader br = new BufferedReader(input1)) {
	    	    String line;
	    	    int index = 0;
	    	    while ((line = br.readLine()) != null) {
	    	    	List<String> data = Arrays.asList(line.split(","));
	    	    	if (key == 0 ) {
	    	    		for (int i = 0; i<data.size(); i++) {
	    	    			if ( data.get(i).equals("price")) {
	    	    				index = i;
	    	    			}
	    	    		}
						key =1;
					}
	    	    	System.out.println(data.get(index));
	    	    }
	      }
	    }
	    catch(Exception e) {
	      e.getStackTrace();
	    }
	}

}
