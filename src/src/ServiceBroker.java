import java.util.*;

public class ServiceBroker {
	
	protected String serviceFileLocation = "";
	
	public static String parseInstruction(String input)
	{
		Scanner in = new Scanner(input);
		in.useDelimiter(",");
		
		String serviceCode = in.next();
		String serviceArgs = in.nextLine();
		
		Integer returnCode = -1;
		
		String output = "";
		
		switch(serviceCode)
		{
		case "MESSAGE":
			output = callMessage(serviceArgs);
			returnCode = 0;
			break;
		case "TRANSLATE":
			output = callTranslator(serviceArgs);
			returnCode = 0;
			break;
		case "TAX":
			output = callTaxCalc(serviceArgs);
			returnCode = 0;
			break;
		default:
			output = callMessage("408");
			returnCode = 4;
			break;
		}
		
		return returnCode + "," + output;
	}
	
	private static String callTranslator(String query)
	{
		//Calls the translate module using the service.txt file
		return query;
	}
	
	private static String callTaxCalc(String query)
	{
		//Calls the Tax Calculator module
		return query;
	}
	
	private static String callMessage(String query)
	{
		//Calls the Message module
		return query;
	}
}
