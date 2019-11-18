package tlvprocessor;

/**
 * Created by pratik on 24/2/18.
 * An enumeration for all the valid TLV types
 */
public enum TLVTypes {
    UPPRCS, REPLCE;

    public static boolean isValid(String value){
        boolean isValid = false;
        for (TLVTypes type : values()) {
            if(type.toString().equalsIgnoreCase(value)){
                isValid = true;
            }
        }
        return isValid;
    }
}
