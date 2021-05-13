package taxcalculator;
import java.io.*;
import java.util.ArrayList;

//Format TaxCalculator.jar YEAR INCOME STATUS

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
			
			ArrayList<Integer> max = new ArrayList<Integer>();
			max.add(0);
			ArrayList<Double> rate = new ArrayList<Double>();
			rate.add(0.0);
			
			int left = Integer.parseInt(args[1]); 
			double taxOwed = 0;
			
			while ((s = in.readLine())!=null) {
				data = s.split(",");
				if (data[0].equals("Over"))
					max.add(Integer.MAX_VALUE);
				else
					max.add(Integer.parseInt(data[0]));
				
				rate.add(Double.parseDouble(data[1]));
			}
			
			for (int i = 1; i < max.size() && left > 0; i++) {
				double df = Math.min(max.get(i) - max.get(i - 1), left);
				taxOwed += rate.get(i)*df;
				left -= df;
			}
			
			System.out.println(taxOwed);
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("TABLE NOT FOUND");
		}

	}
}
