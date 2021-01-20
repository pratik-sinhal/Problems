package STRINGS;

import java.util.Arrays;

public class ValidateIPAddress {
    public static void main(String[] args) {
        String ip = "128.0.0.1";
        String ip2 = "128.05.0.1";
        System.out.println(isValid(ip));
    }

    private static boolean isValid(String ip) {
        String[] groups = ip.split("\\.");
        if(groups.length < 4)
            return false;
        return Arrays.stream(groups)
                .filter(p-> ((p.length() == 1) || (p.length()>1 && !p.startsWith("0"))))
                .map(Integer::parseInt)
                .filter(p->(p>=0 && p<=255))
                .count() == 4;
    }
}
