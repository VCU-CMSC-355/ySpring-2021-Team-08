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
			}while(foundFlag==false && serviceFile.hasNext());
			
			//If we find the code, we call the module and pass in the arguments.
			if(foundFlag)
			{
				String serviceArgs = "";
				
				if(in.hasNext())
				{
					serviceArgs = in.nextLine();
				}
				//If no arguments were passed through, return a no-argument error.
				else
				{
					returnData = parseInstruction("MESSAGE,402").substring(2);
					returnCode = 4;
					
					serviceFile.close();
					in.close();
					
					return returnCode + "," + returnData;
				}
				
				try
				{
					serviceArgs = serviceArgs.substring(1).replace(',', ' ');
					
					//If arguments are empty, return a no-argument error.
					if(serviceArgs.equals("") || serviceArgs.equals(" ") || serviceArgs.equals("  ") || serviceArgs.equals("   ") || serviceArgs.equals("   "))
					{
						returnData = parseInstruction("MESSAGE,402").substring(2);
						returnCode = 4;
						
						serviceFile.close();
						in.close();
						
						return returnCode + "," + returnData;
					}
					
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
					returnData = parseInstruction("MESSAGE,403").substring(2);
					//returnData += "; " + e.getMessage();
					returnCode = 4;
				}
			}
			//If we don't find the code, create an error message.
			else
			{
				returnData = parseInstruction("MESSAGE,404").substring(2);
				returnCode = 4;
			}
			
			serviceFile.close();
		}
		//If something fails, create an error message.
		catch(Exception e)
		{
			returnData = parseInstruction("MESSAGE,401").substring(2);
			returnData += "; " + e.toString();
			returnCode = 4;
		}
		
		in.close();
		
		return returnCode + "," + returnData;
	}
}
