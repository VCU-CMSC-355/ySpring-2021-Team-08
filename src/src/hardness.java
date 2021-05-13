import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class hardness {
	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
		Boolean end = false;
		
		String utilityPath = new File("modules\\serviceBroker.jar").getAbsolutePath();
		
		while(!end)
		{
			System.out.println("Specify the Service Broker's command: ");
			System.out.println("(Ex.: TAX,2020,10000,S | MESSAGE,401 | TRANSLATE,cat,german)");
			String command = scanner.nextLine();
			String utility = "java -jar \"" + utilityPath + "\" " + command;
			Process p = Runtime.getRuntime().exec(utility);
			BufferedReader moduleOutput = new BufferedReader(new InputStreamReader(p.getInputStream()));
				
			String output = "";
			String curr = "";
			while(curr != null)
			{
				curr = moduleOutput.readLine();
				if(curr!=null)
				{
					output += curr;
				}
			}
			
			System.out.println(output);
			p.destroy();
			
			System.out.println("End program? (y/n)");
			command = scanner.nextLine();
			if(command.equalsIgnoreCase("y") || command.equalsIgnoreCase("yes"))
			{
				end = true;
			}
		}
		scanner.close();
    }
}
