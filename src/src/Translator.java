import java.util.*;
import java.io.*;


public class Translator {
	public static void main(String[] args) {
		String engIn = "", tranLn = "";
		 if(args.length == 0)
			  System.out.println("Index out of bounds");
		  else {
			  engIn = args[0];
			  tranLn = args[1];
			  returnTranslation(engIn, tranLn);
		  }
	}
	
	static void returnTranslation(String eng, String lang) {
	      try {
	     	 String brokerPath = new File("brokers/"+lang+".txt").getAbsolutePath();
	         Scanner input = new Scanner(new File(brokerPath));
	         String temp="", tranWd ="";
	         
	         while(input.hasNextLine()) {
	        	 temp=input.nextLine();
	        	 String arg1[] = temp.split(",");
	        	 if(arg1[0].equals(eng)) {
	        		 tranWd = arg1[1];
	        		 
	        	 }
	         }
	         
	         input.close();
	         
	         System.out.println(tranWd);
	      } catch (FileNotFoundException e) { 
		        System.out.println("FileNotFoundException");
		    }
	}
}
