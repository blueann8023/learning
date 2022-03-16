package me.lm.algorithm.string;

import org.junit.Test;
import org.springframework.util.StringUtils;

/**
 * @author bule_ann
 * @since 2022/3/4
 */
public class StringSortSolution {

    @Test
    public void a() {
        System.out.println("cccccbaaba".compareTo("cccccba"));
        System.out.println(maxDictionaryOrder("aabcbccacbbcbaaba"));
    }

    public int turnTimes(String s) {
        // write code here
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + s.charAt(i) - 'A';
        }
        int origin = ('C' - 'A') * 26 * 26 + ('M' - 'A') * 26 + 1;
        return origin - result;

    }

    public String maxDictionaryOrder(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int[] result = new int[s.length()];
        int resultIndex = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(max)) {

                result[resultIndex] = i;
                resultIndex++;
            } else if (s.charAt(i) > s.charAt(max)) {
                resultIndex = 0;
                result[resultIndex] = i;
                max = i;
                resultIndex++;
            }
        }
        String ss = "";
        for (int i = 0; i < resultIndex; i++) {
            ss = ss + s.charAt(result[i]);
        }

        int lastMaxIndex = result[resultIndex - 1];
        lastMaxIndex++;
        if (lastMaxIndex < s.length()) {
            ss = ss + maxDictionaryOrder(s.substring(lastMaxIndex));
        }

        return ss;
    }

    //key-indexed count
    public void sort(String s) {
        char[] chars = s.toCharArray();

    }

    //LSD-Least-significant-digit-first 最低位优先
    public void sortLSD(String[] s, int M) {

    }

    //MSD-Most-significant-digit-first  最高位优先
    public void sortMSD(String[] s, int M) {

    }
}
