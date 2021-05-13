//package taxcalculator;
import java.io.*;

public class Calculator {
	public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println("WRONG INPUT");
			System.exit(0);
		}
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(args[0] + args[2] + ".txt"))); 
			String s = null;
			String[] data;
			while ((s = in.readLine())!=null) {
				data = s.split(",");
				if (data[0].equals("Over")) {
					System.out.println(Integer.parseInt(args[1]) * Double.parseDouble(data[1]));
				} else if (Integer.parseInt(args[1]) <= Integer.parseInt(data[0])) {
					System.out.println(Integer.parseInt(args[1]) * Double.parseDouble(data[1]));
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("TABLE NOT FOUND");
		}

	}
}
