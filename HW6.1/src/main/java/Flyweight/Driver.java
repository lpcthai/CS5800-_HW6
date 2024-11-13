package Flyweight;
import java.util.ArrayList;
import java.util.List;
public class Driver {
    private static final String[] fonts = {"Arial", "Calibri", "Verdana"};
    private static final int[] fontSizes = {12, 14, 16};
    private static final String[] colors = {"Red", "Blue", "Black"};
    private static final String filePath = "src/Flyweight/";

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.create(createTexts("HelloWorldCS5800"));
        textEditor.save(filePath + "HelloWorldCS5800.txt");
    }

    public static List<Text> createTexts(String words) {
        List<Text> texts = new ArrayList<>();
        for (int i = 0; i < words.length(); i++) {
            String randomColor = colors[(int) (Math.random() * colors.length)];
            String randomFont = fonts[(int) (Math.random() * fonts.length)];
            int randomFontSize = fontSizes[(int) (Math.random() * fontSizes.length)];
            texts.add(new Text(words.substring(i, i + 1), randomFont, randomFontSize, randomColor));
        }
        return texts;
    }
}
