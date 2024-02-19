package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class PairedTag extends Tag{
public String body;
public List<Tag> singleTag;

    public PairedTag(String name, Map<String, String> atribute, String body, List<Tag> singleTag) {
        super(name, atribute);
        this.body = body;
        this.singleTag = singleTag;
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("<").append(name);
        for(Map.Entry<String,String> entry : atribute.entrySet()) {
            result.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        result.append(">").append(body);
        for (Tag single : singleTag){
        result.append(single.toString());
        }
        result.append("</").append(name).append(">");
        return result.toString();
    }

}
