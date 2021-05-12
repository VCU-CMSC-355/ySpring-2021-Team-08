import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TranslatorTest {

    @Test
    @DisplayName("No argument")
    public void translateNoArgsTest1() {
        Translator translator = new Translator("");
        String expected = "If you're seeing this, your string input wasn't in the correct format," +
                "most likely because we coded something wrong. Whoops.";
        String output = translator.translate();

        assertEquals(expected, output);
    }
    @Test
    @DisplayName("Whitespace argument")
    public void translateNoArgsTest2() {
        Translator translator = new Translator(" ");
        String expected = "If you're seeing this, your string input wasn't in the correct format," +
                "most likely because we coded something wrong. Whoops.";
        String output = translator.translate();

        assertEquals(expected, output);
    }
    @Test
    @DisplayName("Whitespace argument w/ comma")
    public void translateNoArgsTest3() {
        Translator translator = new Translator(" , ");
        String expected = "If you're seeing this, your string input wasn't in the correct format," +
                "most likely because we coded something wrong. Whoops.";
        String output = translator.translate();

        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Spanish test")
    public void translateTestSpanish() {
        Translator translator = new Translator("cat,Spanish");
        String expected = "gato";
        String output = translator.translate();

        assertEquals(expected, output);
    }
    @Test
    @DisplayName("German test")
    public void translateTestGerman() {
        Translator translator = new Translator("cat,German");
        String expected = "katz";
        String output = translator.translate();

        assertEquals(expected, output);
    }
    @Test
    @DisplayName("French test")
    public void translateTestFrench() {
        Translator translator = new Translator("cat,French");
        String expected = "chat";
        String output = translator.translate();

        assertEquals(expected, output);
    }
    @Test
    @DisplayName("Klingon test")
    public void translateTestKlingon() {
        Translator translator = new Translator("cat,Klingon");
        String expected = "mangHom";
        String output = translator.translate();

        assertEquals(expected, output);
    }
    @Test
    @DisplayName("Missing word")
    public void translateTestMissingWord() {
        Translator translator = new Translator(",German");
        String expected = "If you're seeing this, your string input wasn't in the correct format," +
                "most likely because we coded something wrong. Whoops.";
        String output = translator.translate();

        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Missing language")
    public void translateTestMissingLanguage() {
        Translator translator = new Translator("cat,");
        String expected = "If you're seeing this, your string input wasn't in the correct format," +
                "most likely because we coded something wrong. Whoops.";
        String output = translator.translate();

        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Wrong word")
    public void translateTestWrongWord() {
        Translator translator = new Translator("caat,Spanish");
        String expected = "MESSAGE,813";
        String output = translator.translate();

        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Wrong language")
    public void translateTestWrongLanguage() {
        Translator translator = new Translator("cat,Spanishh");
        String expected = "MESSAGE,805";
        String output = translator.translate();

        assertEquals(expected, output);
    }
}