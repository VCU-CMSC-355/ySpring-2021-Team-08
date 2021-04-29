import java.util.*;
import java.io.*;

/** 
 * Module: Service Broker
 * Component: Orchestration Services
 * ************************************
 * Function:
 *   Calls the translator, message, and tax calculator modules 
 *   based upon the entered-in instruction.
 *   
 * ------------------------------------
 * Input: 
 * 		Instruction as "OPCODE,args"
 * Output: 
 * 		ReturnCode and ReturnData as "ReturnCode,ReturnData"
 * ------------------------------------
 * @author Haley Currence
 * @version 4/27/2021 CMSC 355 - Spring 2021
 */
public class ServiceBroker {
	
	protected static String brokerFileLocation = "brokers/service.txt";
	
	public static void main(String[] args)
	{
		for(String arg : args)
		{

			parseInstruction(arg);
		}
	}
	
	/**
	 * The parseInstruction method takes in an instruction, calls the 
	 * appropriate module according to the instruction, and returns the 
	 * output of that module with the appropriate return code.
	 * 
	 * @param instruction - String
	 * @return returnCode and returnData - a combined String
	 */
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
					returnData = parseInstruction("MESSAGE,402,english");
					returnData += "; " + e.getMessage();
					returnCode = 4;
				}
			}
			//If we don't find the code, create an error message.
			else
			{
				returnData = parseInstruction("MESSAGE,403,english");
				returnCode = 4;
			}
			
			serviceFile.close();
		}
		//If something fails, create an error message.
		catch(Exception e)
		{
			returnData = parseInstruction("MESSAGE,401,english");
			returnData += "; " + e.getMessage();
			returnCode = 4;
		}
		
		in.close();
		
		return returnCode + "," + returnData;
	}
}
