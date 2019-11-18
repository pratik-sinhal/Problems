package tlvprocessor;

/**
 * Created by pratik on 24/2/18.
 */
public class TLVServiceImpl implements ITLVService {

    public static final String SEPARATOR = "-";
    public static final String TYPE_NOT_VALID = "Type not valid";

    /**
     * TLV input processor input
     * @param input
     */
    @Override
    public void processTLVS(String input) {
        processTLVByParts(input);
    }

    private void processTLVByParts(String tlvInput) {
        String[] tlvParts = tlvInput.split(SEPARATOR);
        for (int i = 0; i < tlvParts.length;) {
            String tlvType = tlvParts[i++];
            Integer tlvLength = Integer.parseInt(tlvParts[i++],10);
            String tlvValue = tlvParts[i];
            // processing to check if their are multiple TLVs in the incoming input
            String nextTLV = tlvValue.substring(tlvLength);
            if(!"".equals(nextTLV)) {
                tlvValue = tlvValue.substring(0, tlvLength);
                tlvParts[i] = nextTLV;
            } else {
                ++i;
            }
            outputTLV(tlvType, tlvLength, tlvValue);
        }
    }

    private void outputTLV(String tlvType, Integer tlvLength, String tlvValue) {
        if(!TLVTypes.isValid(tlvType)) {
            System.out.println(TYPE_NOT_VALID);
        } else {
            TLVType tlvInstance = TLVFactory.getTLVInstance(TLVTypes.valueOf(tlvType), tlvLength, tlvValue);
            /* Designed for extensibility using OPEN-CLOSED & SUBSTITUTION principle.
             * Whenever new processors like LOWRCS are added this code does not need to change. Processing
             * of the new tag will be handled using abstraction. All we need to process a new type is to
             * create a new class as a child of (read type of) abstract class TLVTYPE.
             * Hence there will be no testing impact on this part.
             */
            System.out.println(tlvInstance.process());
        }
    }
}
