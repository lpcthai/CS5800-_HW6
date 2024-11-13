import Flyweight.Text;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TextTest {
    @Test
    public void testTextInitialization() {
        Text text = new Text("Hello", "Arial", 12, "Red");
        String expectedOutput = "Hello, Arial, 12, Red";
        assertEquals(expectedOutput, text.getText());
    }
    @Test
    public void testTextInitializationWithDifferentProperties() {
        Text text = new Text("World", "Calibri", 14, "Blue");
        String expectedOutput = "World, Calibri, 14, Blue";
        assertEquals(expectedOutput, text.getText());
    }
}
