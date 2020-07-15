/*public class JavaStreams {
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		Map<Boolean, List<Integer>> result = myList.stream().collect(Collectors.partitioningBy(x->x%2==0));
		System.out.println(result.get(true));
		System.out.println(result.get(false));
		
		myList.add(10);
		System.out.println(myList.stream().min(Comparator.comparing(e->-e)).orElse(null));
		myList.forEach(e->System.out.print(e));
	}
}*/
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
