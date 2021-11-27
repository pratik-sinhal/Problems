package SORTING;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    public String largestNum(int[] nums){
        if(nums.length == 0)
            return "0";

        if(nums.length == 1)
            return String.valueOf(nums[0]); // also Integer.toString(a[0])

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String s1 = a + b;
                String s2 = b + a;
                return s1.compareTo(s2);
            }
        });

        Arrays.sort(strs, (a,b) -> {
            String s1 = a + b;
            String s2 = b + a;
            return s1.compareTo(s2);
        });

        //Arrays.sort(strs, Comparator.comparing());

        List<Integer> list = new ArrayList<>();

        //edge case when all elements in array are zero
        if("0".equals(strs[0]))
            return "0";

        StringBuilder res = new StringBuilder("");
        for (String s : strs) {
            res.append(s);
        }

        return res.toString();
    }

    public class ComparatorSort implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            String s1 = a + b;
            String s2 = b + a;
            return s1.compareTo(s2);
        }
    }
}
