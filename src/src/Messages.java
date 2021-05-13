import java.util.*;
import java.io.*;

/*
 *****************************
 * File: Messages
 *
 * Description: 
 * Gets called by the service broker and outputs
 * certain error message back to service broker
 *
 * Author: Shashank Bhatt
 * Date: April 29, 2021 
 * Class: CMSC 355
 *
 ******************************
 */

public class Messages{ 
   public static void main(String[] args){
      //args[0] = "MSG_NUMBER" 
      //args[1] = "Language for you to convert from text file"
	  int MsgNumber;
	  if(args.length == 0)
		  System.out.println("Index out of bounds");
	  else {
		  MsgNumber = Integer.parseInt(args[0]);
      	  returnMessage(MsgNumber);
	  }
   }
   
   static void returnMessage(int MsgNumber){ 
      try {
         Scanner input = new Scanner(new File("MessageList.txt"));
         String tmp="", errorMsg="";
      
         while(input.hasNextLine()){
            tmp = input.nextLine();
            if(tmp.substring(0,3).equals(String.valueOf(MsgNumber)) == true){
               errorMsg = tmp.substring(4); 
            }
         }   
      
         input.close();
      
         System.out.println(errorMsg); 
      } catch (FileNotFoundException e) { 
         System.out.println("FileNotFoundException");
      }
   } 
   
}//end class
