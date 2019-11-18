package tlvprocessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by pratik on 24/2/18.
 * Test class
 */
public class TestTLVProcessor {

    public static void main(String[] args) throws IOException{
        ITLVService tlvService = new TLVServiceImpl();
        // take input from command line if provided
        if(args.length > 0) {
            for (String arg : args) {
                tlvService.processTLVS(arg);
            }
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String input;
            while ((input = in.readLine()) != null) {
                try {
                    tlvService.processTLVS(input);
                } catch (ArrayIndexOutOfBoundsException e) {
                    // do nothing
                }
            }
        }
    }
}
