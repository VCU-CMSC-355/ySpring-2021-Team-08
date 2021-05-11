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

public class Messages implements ServiceBroker{ 
   protected int MsgNumber;
   
   MsgNumber = ServiceBroker.returnData; 
   returnMessage(MsgNumber);   
    
   static void returnMessage(int MsgNumber){ throws FileNotFoundException
      File file = new File("MessageList.txt");
      Scanner input = new Scanner(file);
      String tmp="", errorMsg="";
      
      while(input.hasNextLine()){
         tmp = input.nextLine();
         if(tmp.substring(0,3).equals(String.valueOf(MsgNumber)) == true){
            errorMsg = tmp.substring(4); 
         }
      } input.close();
      
      System.out.println(errorMsg); 
   }
   
}//end class

