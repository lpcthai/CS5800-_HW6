import Flyweight.*;
import org.junit.jupiter.api.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextEditorTest {
    private static final String FILE_PATH = "src/Flyweight/TestFile.txt";
    @Test
    public void testCreateAndSaveFile() throws Exception {
        TextEditor textEditor = new TextEditor();
        List<Text> texts = new ArrayList<>();
        texts.add(new Text("H", "Arial", 12, "Red"));
        texts.add(new Text("e", "Calibri", 14, "Blue"));
        texts.add(new Text("l", "Verdana", 16, "Black"));
        textEditor.create(texts);
        textEditor.save(FILE_PATH);
        File savedFile = new File(FILE_PATH);
        assertTrue(savedFile.exists(), "File should be created and saved successfully");
        List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
        assertEquals(3, lines.size(), "The file should contain 3 lines");
        assertEquals("H, Arial, 12, Red", lines.get(0), "The first text element");
        assertEquals("e, Calibri, 14, Blue", lines.get(1), "The second text element");
        assertEquals("l, Verdana, 16, Black", lines.get(2), "The third text element");
    }
    @Test
    public void testLoadFile() throws Exception {
        TextEditor textEditor = new TextEditor();
        List<Text> texts = new ArrayList<>();
        texts.add(new Text("L", "Arial", 12, "Red"));
        texts.add(new Text("o", "Calibri", 14, "Blue"));
        textEditor.create(texts);
        textEditor.save(FILE_PATH);
        TextEditor loadedEditor = new TextEditor();
        loadedEditor.load(FILE_PATH);
        loadedEditor.save(FILE_PATH);
        List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
        assertEquals(2, lines.size(), "The file should contain 2 lines");
        assertEquals("L, Arial, 12, Red",lines.get(0));
        assertEquals("o, Calibri, 14, Blue",lines.get(1));
    }

    @Test
    public void testEditFile() throws Exception {
        TextEditor textEditor = new TextEditor();
        List<Text> texts = new ArrayList<>();
        texts.add(new Text("E", "Arial", 12, "Red"));
        texts.add(new Text("L", "Calibri", 14, "Blue"));
        textEditor.create(texts);
        textEditor.save(FILE_PATH);
        List<Text> newText = new ArrayList<>();
        newText.add(new Text("H", "Verdana", 16, "Black"));
        newText.add(new Text("L", "Arial", 12, "Red"));
        textEditor.edit(FILE_PATH, newText);
        List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
        assertEquals(2, lines.size(),"The file should contain 2 lines");
        assertEquals("H, Verdana, 16, Black", lines.get(0));
        assertEquals("L, Arial, 12, Red", lines.get(1));
    }

}
