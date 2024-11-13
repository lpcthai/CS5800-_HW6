import Flyweight.TextProperties;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TextPropertiesTest {
    @Test
    public void testGetProperties() {
        TextProperties textProperties = new TextProperties("Arial", 12, "Red");
        String result = textProperties.getProperties();
        assertEquals("Arial, 12, Red",result);
    }
}
