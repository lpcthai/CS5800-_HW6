package Flyweight;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextEditor implements Editable {
    private List<Text> text;
    @Override
    public void create(List<Text> text) {
        this.text = text;
    }
    @Override
    public void edit(String fileName, List<Text> documentText) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                throw new IOException("File not found: " + fileName);
            }
            FileWriter writer = new FileWriter(file);
            for (Text text : documentText) {
                writer.write(text.getText() + "\n");
            }
            writer.close();
            this.text = documentText;
            System.out.println("File edited successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while editing the file.");
            e.printStackTrace();
        }
    }

    @Override
    public void save(String fileName) {
        try {
            // Create the directories if they don't exist
            File file = new File(fileName);
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();  // Creates the directory if it doesn't exist
            }

            // Now save the file
            FileWriter writer = new FileWriter(file);
            for (Text text : this.text) {
                writer.write(text.getText() + "\n");
            }
            writer.close();
            System.out.println("Successfully saved to the file " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file.");
            e.printStackTrace();
        }
        System.out.println("Successfully saved to the file " + fileName);

    }

    public void load(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            List<Text> loadedText = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                loadedText.add(parseText(line));
            }
            this.text = loadedText;
            System.out.println("File loaded successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while loading the file.");
            e.printStackTrace();
        }
    }
    private Text parseText(String line) {
        String[] parts = line.split(", ");
        if (parts.length == 4) {
            String text = parts[0];
            String font = parts[1];
            int fontSize = Integer.parseInt(parts[2]);
            String color = parts[3];
            return new Text(text, font, fontSize, color);
        }
        return null;
    }
}
