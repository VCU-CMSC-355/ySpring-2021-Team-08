import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Harness for ServiceBrokerTesting
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
	public void noArgsTest1() {
		String input = "TRANSLATE";
		String expected = "0,gato";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	@Test
	public void noArgsTest2() {
		String input = "TRANSLATE,,";
		String expected = "0,gato";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	@Test
	public void noArgsTest3() {
		String input = "TRANSLATE, , ";
		String expected = "0,gato";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	
	@Test
	public void translateTest1() {
		String input = "TRANSLATE,cat,spanish";
		String expected = "0,gato";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	@Test
	public void translateTest2() {
		String input = "TRANSLATE,cat,german";
		String expected = "0,katz";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	@Test
	public void translateTest3() {
		String input = "TRANSLATE,cat,french";
		String expected = "0,chat";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	@Test
	public void translateTest4() {
		String input = "TRANSLATE,cat,klingon";
		String expected = "0,mangHom";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	@Test
	public void translateTest5() {
		String input = "TRANSLATE,cat,english";
		String expected = "0,cat";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	
	@Test
	public void taxTest1() {
		String input = "TAX,2020,Single,10000";
		String expected = "0,2020 Single 10000";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	
	@Test
	public void messageTest1() {
		String input = "MESSAGE,404,language";
		String expected = "0,404 language";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}

}
