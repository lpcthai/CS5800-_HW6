package Flyweight;

public class Text {
    private String text;
    private TextProperties textProperties;

    public Text(String text, String font, int fontSize, String color) {
        this.text = text;
        TextPropertiesFactory textPropertiesFactory = new TextPropertiesFactory();
        this.textProperties = textPropertiesFactory.getTextProperties(font, fontSize, color);
    }

    public String getText() {
        return text + ", " + getTextProperties();
    }

    private String getTextProperties() {
        return textProperties.getProperties();
    }
}

