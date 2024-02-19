package exercise;

import java.util.stream.Collectors;
import java.util.Map;
public class Tag {
    public String name;
    public Map<String,String> atribute;

    public Tag(String name, Map<String, String> atribute) {
        this.name = name;
        this.atribute = atribute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getAtribute() {
        return atribute;
    }

    public void setAtribute(Map<String, String> atribute) {
        this.atribute = atribute;
    }
}
