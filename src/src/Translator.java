//import java.util.Locale;
import java.util.*;
import java.io.*;
//import java.util.regex.PatternSyntaxException;

/******************************
 * Translator Class
 ******************************
 * Function:
 * Receives translate query and searches for matching language file and word. If either can't be found, or query is in
 * incorrect format, output error message number. Otherwise, output translated word.
 ******************************
 * @author Stephen Liu
 * @version 04/18/2021 CMSC 355
 */
public class Translator {
    protected String engWord;
    protected String language;

    /**
     * Takes String input. If input has no comma, or has empty/whitespace parameters on either side of the comma,
     * makes Translator variables empty strings. Otherwise, splits it by comma and makes first substring "engWord"
     * and second substring "language".
     *
     * @param input The parameter list being passed to the translate module
     */
    public Translator(String input) {
        String trimmedString = input.trim();
        String[] parsedString = input.split(" ");
        if(!input.contains(" ") || trimmedString.indexOf(" ") == 0 || trimmedString.indexOf(" ") == trimmedString.length()-1){
            this.engWord = "";
            this.language = "";
        } else{
            this.engWord = parsedString[0];
            this.language = parsedString[1];
        }
    }

    /**
     * Calls a Translator object's translate method, sees if a language file that matches its language variable exists.
     * If so, searches by line for the Translator's engWord (ignoring case). If it does, returns the other parsed
     * section. If not, returns the error number for "word not found". If no language file exists for the Translator's
     * language, returns the error number for "language not found".
     *
     * @return A String representing the correctly translated word if no exceptions are thrown, or the
     * corresponding error message number if an exception is thrown.
     */
    public String translate(){
        String filePath = new File("brokers").getAbsolutePath();
        filePath = filePath.concat("\\" + this.language.toLowerCase() + ".txt");
        File file = new File(filePath);
        boolean wordFound = false;
        String[] word = new String[0];

        if(this.engWord.equals("") && this.language.equals("")){
            return "If you're seeing this, your string input wasn't in the correct format," +
                    "most likely because we coded something wrong. Whoops.";
        }

        try {
            Scanner scan = new Scanner(file);
            while (!wordFound && scan.hasNextLine()) {
                word = scan.nextLine().split(",");
                if (word[0].equalsIgnoreCase(this.engWord)) {
                    wordFound = true;
                }
            }
            if (wordFound) {
                return word[1];
            } else {
                return ServiceBroker.parseInstruction("MESSAGE,813");
            }
        } catch (FileNotFoundException E){
            return ServiceBroker.parseInstruction("MESSAGE,805");
        }
    }
    public static void main(String[] args){
    	if(args[0]!=null && args[1]!=null)
    	{
	    	String temp = args[0] + " " + args[1];
	    	//String temp = "cat german";
	        Translator t = new Translator(temp);
	        System.out.println(t.translate());
    	}
    }
}
