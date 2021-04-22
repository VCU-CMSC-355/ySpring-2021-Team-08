import java.util.*;
import java.io.*;

/* 
 * Module: Service Broker
 * Component: Orchestration Services
 * ************************************
 * Function:
 *   Calls the translator, message, and tax calculator modules 
 *   based upon the entered-in instruction.
 *   
 * ------------------------------------
 * Input: 
 * 		Arguments - Instruction as "OPCODE,args"
 * Output: 
 * 		Return - "ReturnCode,ReturnData"
 * ------------------------------------
 * Author: Haley Currence
 * Version Date: 4/21/2021 CMSC 355 - Spring 2021
 */

public class ServiceBroker {
	
	protected static String brokerFileLocation = "brokers/service.txt";
	
	public static void main(String[] args)
	{
		System.out.println(parseInstruction("TRANSLATE,args"));
	}
	
	public static String parseInstruction(String instruction)
	{
		Scanner in = new Scanner(instruction);
		in.useDelimiter(",");
		
		String serviceCode = in.next();
		
		Integer returnCode = -1;
		String returnData = "";
		
		Boolean foundFlag = false;
		String utilityModule = "";
		
		try
		{
			String brokerPath = new File(brokerFileLocation).getAbsolutePath();
			File brokerFile = new File(brokerPath);
			Scanner serviceFile = new Scanner(brokerFile);
			serviceFile.useDelimiter(",");
			
			do
			{
				//read service file codes for serviceCode
				String code = serviceFile.next();
				
				if(code.equals(serviceCode))
				{
					utilityModule = serviceFile.nextLine().substring(1);
					foundFlag = true;
				}
				
			}while(foundFlag==false || serviceFile.hasNext()==false);
			
			if(foundFlag)
			{
				String serviceArgs = in.nextLine();
				try
				{
					serviceArgs = serviceArgs.substring(1).replace(',', ' ');
					
					String utilityPath = new File(utilityModule).getAbsolutePath();
					
					utilityModule = "java -jar " + utilityPath + " " + serviceArgs;
					Process p = Runtime.getRuntime().exec(utilityModule);
					BufferedReader moduleOutput = new BufferedReader(new InputStreamReader(p.getInputStream()));
						
					String curr = "";
					do
					{
						curr = moduleOutput.readLine();
						returnData += curr;
					}while(curr != null);
					
					returnCode = 0;
				} 
				catch (IOException e)
				{
					returnData = e.getMessage();
					returnCode = 5;
				}
			}
			else
			{
				returnData = parseInstruction("MESSAGE,408");
				returnCode = 4;
			}
			
			serviceFile.close();
		}
		catch(Exception e)
		{
			returnData = parseInstruction("MESSAGE,401");
			returnCode = 4;
		}
		
		in.close();
		
		return returnCode + "," + returnData;
	}
}
