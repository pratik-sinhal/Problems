package tlvprocessor;

/**
 * Created by pratik on 24/2/18.
 * Abstract class to represent each TLV type. Use of Substitution principle.
 * This class provides the necessary abstraction to represent each TLV type & to
 * provide for the required extensibility
 */
public abstract class TLVType {
    protected TLVTypes type;
    protected Integer length;
    protected String value;

    public TLVType(TLVTypes type, Integer length, String value) {
        this.type = type;
        this.length = length;
        this.value = value;
    }

    public TLVTypes getType() {
        return type;
    }

    public void setType(TLVTypes type) {
        this.type = type;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public abstract String process();
}
