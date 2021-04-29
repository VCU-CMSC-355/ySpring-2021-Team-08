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
 * 		Return - ReturnCode and ReturnData as "ReturnCode,ReturnData"
 * ------------------------------------
 * Author: Haley Currence
 * Version Date: 4/21/2021 CMSC 355 - Spring 2021
 */

public class ServiceBroker {
	
	protected static String brokerFileLocation = "brokers/service.txt";
	
	public static void main(String[] args)
	{
		//for(String arg : args)
		{
<<<<<<< HEAD
			parseInstruction(arg);
=======

			System.out.println(parseInstruction("TAX,args"));
>>>>>>> parent of 0fae2b0 (Update JavaDoc for ServiceBroker and ServiceBrokerTest)
		}
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
			
			//Searches through the broker file for the serviceCode.
			do
			{
				String code = serviceFile.next();
				
				if(code.equals(serviceCode))
				{
					utilityModule = serviceFile.nextLine().substring(1);
					foundFlag = true;
					break;
				}
				
				serviceFile.nextLine();
			}while(foundFlag==false || serviceFile.hasNext()==false);
			
			//If we find the code, we call the module and pass in the arguments.
			if(foundFlag)
			{
				String serviceArgs = in.nextLine();
				try
				{
					serviceArgs = serviceArgs.substring(1).replace(',', ' ');
					
					String utilityPath = new File(utilityModule).getAbsolutePath();
					
					utilityModule = "java -jar \"" + utilityPath + "\" " + serviceArgs;
					Process p = Runtime.getRuntime().exec(utilityModule);
					BufferedReader moduleOutput = new BufferedReader(new InputStreamReader(p.getInputStream()));
						
					String curr = "";
					while(curr != null)
					{
						curr = moduleOutput.readLine();
						if(curr!=null)
						{
							returnData += curr;
						}
					}
					
					p.destroy();
					returnCode = 0;
				} 
				//File-Not-Found/Command-Not-Recognized error
				catch (IOException e)
				{
					returnData = e.getMessage();
					returnCode = 5;
				}
			}
			//If we don't find the code, create an error message.
			else
			{
				returnData = parseInstruction("MESSAGE,408");
				returnCode = 4;
			}
			
			serviceFile.close();
		}
		//If something fails, create an error message.
		catch(Exception e)
		{
			returnData = parseInstruction("MESSAGE,401");
			returnCode = 4;
		}
		
		in.close();
		
		return returnCode + "," + returnData;
	}
}
