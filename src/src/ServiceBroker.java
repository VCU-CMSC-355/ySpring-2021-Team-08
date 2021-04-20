import java.util.*;

public class ServiceBroker {
	
	protected String serviceFileLocation = "";
	
	public static String parseInstruction(String input)
	{
		Scanner in = new Scanner(input);
		in.useDelimiter(",");
		
		String function = in.next();
		String command = in.nextLine();
		
		Integer returnCode = -1;
		
		String output = "";
		
		switch(function)
		{
		case "MESSAGE":
			output = callMessage(command);
			returnCode = 0;
			break;
		case "TRANSLATE":
			output = callTranslator(command);
			returnCode = 0;
			break;
		case "TAX":
			output = callTaxCalc(command);
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
