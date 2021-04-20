import java.util.*;
import java.io.*;

public class ServiceBroker {
	
	protected static String serviceFileLocation = "";
	
	public static String parseInstruction(String input)
	{
		Scanner in = new Scanner(input);
		in.useDelimiter(",");
		
		String serviceCode = in.next();
		
		Integer returnCode = -1;
		String returnData = "";
		
		Boolean foundFlag = false;
		String utilityModuleLocation = "";
		Scanner serviceFile = new Scanner(serviceFileLocation);
		serviceFile.useDelimiter(",");
		
		do
		{
			//read service file codes for serviceCode
			String code = serviceFile.next();
			
			if(code.equals(serviceCode))
			{
				utilityModuleLocation = serviceFile.nextLine();
				foundFlag = true;
			}
			
		}while(foundFlag==false || serviceFile.hasNext()==false);
		
		if(foundFlag)
		{
			String serviceArgs = in.nextLine();
			try
			{
				//Call utlity module with serviceArgs as param
				Process p = Runtime.getRuntime().exec(new String[]{utilityModuleLocation,serviceArgs});
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
		
		return returnCode + "," + returnData;
	}
}
