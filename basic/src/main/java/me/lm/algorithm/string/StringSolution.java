package me.lm.algorithm.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author bule_ann
 * @since 2022/3/4
 */
public class StringSolution {
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        int len = needle.length();
        if (len == 0) {
            return 0;
        }
        int i = 0, l = -1, h = 0;
        while (h < haystack.length() && i < len) {
            if (haystack.charAt(h) == needle.charAt(i)) {
                if (l == -1) {
                    l = h;
                }
                if (h - l == len - 1) {
                    return l;
                }
                h++;
                i++;
            } else {
                if (l == -1) {
                    h++;
                } else {
                    i = 0;
                    h = l + 1;
                    l = -1;
                }
            }
        }
        return -1;
    }

    public int myAtoi(String s) {
        int i = 0;
        boolean hasFirstNumber = false;
        boolean isNegative = false;
        boolean hasFirstChar = false;
        int result = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int number = (int) c - (int) '0';
            boolean isDigit = (number >= 0 && number < 10);
            if (isDigit) {
                if (!hasFirstNumber) {
                    hasFirstNumber = true;
                    isNegative = i > 0 && s.charAt(i - 1) == '-';
                }
                if (!isNegative && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && number > 7)))
                    return Integer.MAX_VALUE;
                if (isNegative && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && number > 8))) {
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + number;
                i++;
            } else {
                if (hasFirstNumber) {
                    break;
                } else {
                    if (c == ' ') {
                        if (hasFirstChar) {
                            break;
                        }
                        i++;
                    } else if (c == '-' || c == '+') {
                        if (hasFirstChar) {
                            break;
                        }
                        hasFirstChar = true;
                        i++;
                    } else {
                        break;
                    }
                }

            }
        }
        return isNegative ? -result : result;
    }

    public int firstNumber(String s) {
        int i = 0;
        boolean hasFirstNumber = false;
        boolean isNegative = false;
        boolean hasFirstChar = false;
        int result = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int number = (int) c - (int) '0';
            boolean isDigit = (number >= 0 && number < 10);
            if (isDigit) {
                if (!hasFirstNumber) {
                    if (number == 0) {
                        return 0;
                    }
                    hasFirstNumber = true;
                    isNegative = i > 0 && s.charAt(i - 1) == '-';
                }
                if (!isNegative && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && number > 7)))
                    return Integer.MAX_VALUE;
                if (isNegative && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && number > 8))) {
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + number;
                i++;
            } else {
                if (hasFirstNumber) {
                    break;
                } else {
                    i++;
                }
            }
        }
        return isNegative ? -result : result;
    }


    public int toNumber(char c) {
        return (int) c - (int) '0';
    }

    //有效的括号
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    //Z 字形变换
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        int row = 0;
        int d = 1;
        for (char c : s.toCharArray()) {
            sbs[row].append(c);
            row = row + d;
            if (row % (numRows - 1) == 0) {
                d = -d;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : sbs
        ) {
            result.append(sb.toString());
        }
        return result.toString();
    }


    //反转每对括号间的子串
    public String reverseParentheses(String s) {
        int[] pairs = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if (s.charAt(i) == ')') {
                int j = stack.pop();
                pairs[i] = j;
                pairs[j] = i;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0, d = 1; i < s.length(); i += d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pairs[i];
                d = -d;
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();

    }

    @Test
    public void test() {
        char[][] table = new char[1][1];
        System.out.println(table[0][0]);
//        System.out.println(longestPalindrome("aacabdkacaa"));
    }

    // 最长回文子串-暴力、中心、动态规划
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        boolean[][] table = new boolean[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            table[i][i] = true;
        }
        int maxL = 1, index = 0;

        for (int j = 1; j < chars.length; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    table[i][j] = false;
                } else {
                    if (j - i < 3) {
                        table[i][j] = true;
                    } else {
                        table[i][j] = table[i + 1][j - 1];
                    }
                }
                if (table[i][j]) {
                    if (j - i + 1 > maxL) {
                        maxL = j - i + 1;
                        index = i;
                    }
                }
            }
        }
        System.out.println(maxL);
        System.out.println(index);
        return s.substring(index, index + maxL);
    }


    // 最长无重复字串
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap();
        char[] chars = s.toCharArray();
        int max = 0, left = 0, right = 0;
        for (; right < chars.length; right++) {
            if (hashMap.containsKey(chars[right])) {
                //记录max
                max = Math.max(right - left, max);
                //窗口收缩
                left = Math.min(left, hashMap.get(chars[right]) + 1);
            }
            hashMap.put(chars[right], right);
        }
        max = Math.max(right - left, max);
        return max;
    }

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

}
