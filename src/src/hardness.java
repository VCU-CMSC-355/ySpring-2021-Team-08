import java.io.IOException;


public class hardness {
	public static void main(String[] args) throws IOException {
        /*ProcessBuilder in = new ProcessBuilder("java", "-jar", "C:\\Users\\Joshua\\Documents\\GitHub\\Spring-2021-Team-08\\src\\modules\\messages.jar", "401");
        BufferedReader ix = new BufferedReader(new InputStreamReader(in.start().getInputStream()));
        String s = null;
        while((s = ix.readLine()) != null) { 
            System.out.println(s);
        }*/
		
		String input = "MESSAGE,830";
		//String expected = "0,Word Not Found";
		String output = ServiceBroker.parseInstruction(input);
		System.out.println(output);
		
			String input1 = "TRANSLATE,cat,klingon";
			//String expected1 = "0,gato";
			String output1 = ServiceBroker.parseInstruction(input1);
			System.out.println(output1);
    }
}
