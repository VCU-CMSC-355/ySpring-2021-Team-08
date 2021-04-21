import java.util.Scanner;
import java.io.*;
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
     * Takes String input, splits it by comma, and uses first parsed section as word to be translated, and second
     * parsed section as language to translate.
     *
     * @param input The parameter list being passed to the translate module
     */
    public Translator(String input) {
        String[] parsedInput = input.split(",");
        this.engWord = parsedInput[0];
        this.language = parsedInput[1];
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
    public String translate() {
        File file = new File(this.language.toLowerCase() + ".txt");
        boolean wordFound = false;
        String[] word = new String[0];

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
                return "813";
            }
        } catch (FileNotFoundException e) {
            return "805";
        }
    }
}
