package tlvprocessor;

/**
 * Created by pratik on 24/2/18.
 * Applying the SINGLE-RESPONSIBILITY principle to each TLV type class. The processing logic for each
 * TLV type is in its own process() method
 * Each of them IS A type of the abstract TLVType class.
 * Adding a new type means only adding a new type of abstract class TLVType.
 * Nothing else needs to be done
 */
public class UpperCase extends TLVType {

    public UpperCase(Integer length, String value) {
        super(TLVTypes.UPPRCS, length, value);
    }

    @Override
    public String process() {
        return this.toString();
    }

    @Override
    public String toString() {
        return type + TLVServiceImpl.SEPARATOR + value.toUpperCase();
    }
}
