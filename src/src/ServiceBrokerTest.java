import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Harness for ServiceBrokerTesting
 * Testing Stub: test.jar
 */
public class ServiceBrokerTest {

	/* 
	//Blueprint Test
	@Test
	public void test() {
		String input = "";
		String expected = "";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}*/
	
	@Test
	public void test1() {
		String input = "TRANSLATE,GER,Dog";
		String expected = "0,GER Dog";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	
	@Test
	public void test2() {
		String input = "TAX,2020,Single,10000";
		String expected = "0,2020 Single 10000";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	
	@Test
	public void test3() {
		String input = "MESSAGE,404,language";
		String expected = "0,404 language";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}

}
