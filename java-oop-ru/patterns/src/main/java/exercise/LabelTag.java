package exercise;

public class LabelTag implements TagInterface{
    private String value;
    private TagInterface tagInterface;


    public LabelTag(String value, TagInterface tagInterface) {
        this.tagInterface = tagInterface;
        this.value = value;
    }

    @Override
    public String render() {
        return "<label>" + this.value + tagInterface.render() + "</label>";
    }
}