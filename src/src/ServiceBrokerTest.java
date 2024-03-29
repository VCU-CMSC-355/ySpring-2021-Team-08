import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Harness for ServiceBrokerTesting
 * Testing Stub: test.jar
 * 
 * @author Haley Currence
 * @version 5/4/2021
 */
public class ServiceBrokerTest {

	/* s
	//Blueprint Test
	@Test
	public void test() {
		String input = "";
		String expected = "";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}*/
	
	
	//Tests for if the opcode called does not exist.
	@Test
	public void notOpcodeTest1() {
		String input = "NOTCODE,test,test";
		String expected = "4,Opcode Not Found";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	@Test
	public void notOpcodeTest2() {
		String input = "NOTCODE";
		String expected = "4,Opcode Not Found";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	
	//Tests when no arguments are passed through.
	@Test
	public void opcodeNoArgsTest1() {
		String input = "TRANSLATE";
		String expected = "4,No Arguments Found";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	@Test
	public void opcodeNoArgsTest2() {
		String input = "TRANSLATE,,";
		String expected = "4,No Arguments Found";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	@Test
	public void opcodeNoArgsTest3() {
		String input = "TRANSLATE, , ";
		String expected = "4,No Arguments Found";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	
	//Test for identifying if an error code was received from a module.
	
	
	
	/*
	 * These tests test the integration of the taxCalculator module.
	 */
	@Test
	public void taxTest1() {
		String input = "TAX,2020,10000,S";
		String expected = "0,1002.5";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	@Test
	public void taxTest2() {
		String input = "TAX,2020,9875,S";
		String expected = "0,987.5";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	@Test
	public void taxTestMissingArg1() {
		String input = "TAX,,9875,S";
		String expected = "4,No Arguments Found";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	@Test
	public void taxTestMissingArg2() {
		String input = "TAX,2020,,S";
		String expected = "4,No Arguments Found";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	@Test
	public void taxTestMissingArg3() {
		String input = "TAX,2020,9875,";
		String expected = "4,No Arguments Found";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	
	/*
	 * These tests test the integration of the Message module.
	 */
	@Test
	public void messageTest1() {
		String input = "MESSAGE,404";
		String expected = "0,Opcode Not Found";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	@Test
	public void messageTest2() {
		String input = "MESSAGE,813";
		String expected = "0,Word Not Found";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	@Test
	public void messageTest3() {
		String input = "MESSAGE,401";
		String expected = "0,General Error";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	@Test
	public void messageTestMissingArg1() {
		String input = "MESSAGE,";
		String expected = "4,No Arguments Found";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	
	/*
	 * These tests test the integration of the Translate module.
	 */
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
	public void translateTestMissingArg1() {
		String input = "TRANSLATE,cat,";
		String expected = "0,";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	@Test
	public void translateTestMissingArg2() {
		String input = "TRANSLATE,cat, ";
		String expected = "0,";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	@Test
	public void translateTestMissingArg3() {
		String input = "TRANSLATE,,english";
		String expected = "0,";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}
	@Test
	public void translateTestMissingArg4() {
		String input = "TRANSLATE, ,english";
		String expected = "0,";
		String output = ServiceBroker.parseInstruction(input);
		
		assertEquals(expected, output);	
	}

}
