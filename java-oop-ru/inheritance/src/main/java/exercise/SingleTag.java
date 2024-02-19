package exercise;

import java.util.Map;
public class SingleTag extends Tag {
    public SingleTag(String name, Map<String, String> atribute) {
        super(name, atribute);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(name);
        for(Map.Entry<String,String> entry : atribute.entrySet()) {
            sb.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
sb.append(">");
        return sb.toString();
    }
}
