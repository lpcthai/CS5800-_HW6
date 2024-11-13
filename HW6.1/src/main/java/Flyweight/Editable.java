package Flyweight;

import java.util.List;

public interface Editable {
    void create(List<Text> text);
    void edit(String fileName, List<Text> text);
    void save(String fileName);
}