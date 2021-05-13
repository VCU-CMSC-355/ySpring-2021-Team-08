import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class hardness {
	public static void main(String[] args) throws IOException {

		String utilityPath = new File("modules\\serviceBroker.jar").getAbsolutePath();
		
		utilityPath = "java -jar \"" + utilityPath + "\" TAX,2020,10000,S";
		Process p = Runtime.getRuntime().exec(utilityPath);
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
    }
}
