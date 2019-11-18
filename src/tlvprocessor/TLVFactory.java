package tlvprocessor;

/**
 * Created by pratik on 24/2/18.
 * Factory class to provide the correct TLV type instance
 */
public class TLVFactory {
    /**
     *
     * @param type
     * @param length
     * @param value
     * @return
     */
    public static TLVType getTLVInstance(TLVTypes type, Integer length, String value) {
        TLVType tlvType = null;
        switch (type) {
            case UPPRCS:
                 /*
                  * We can avoid creating new instance for every TLV type each time as we only need to process
                  * its output with changed data.
                  * In that case we can make the Uppercase class singleton and change the instance data each time
                  * and return the same instance from the factory OR
                  * Pre-create instance of each TLV type in this factory class and change the instance data each time
                  * and return the same instance from the factory
                  */
                tlvType = new UpperCase(length, value);
                break;

            case REPLCE:
                tlvType = new Replace(length, value);
                break;

            default:
                throw new IllegalArgumentException("invalid tlvType " + tlvType);
        }
        return tlvType;
    }
}
