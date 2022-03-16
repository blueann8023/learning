package me.lm.algorithm.list;

import org.junit.Test;

import java.util.*;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/3/5
 */
public class ArrayListA {

    @Test
    public void a() {
        int[] a = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(a, 2));

    }

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > queue.peek()) {
                queue.remove();
                queue.add(nums[i]);
            }
        }
        return queue.remove();
//        for (int i = 0; i < k-1; i++) {
//
//        }
//        return queue.remove();
    }

    public int findDuplicate(int[] nums) {
        int l = 1, h = nums.length - 1;
        int ans = -1;
        while (l <= h) {
            int mid = (l + h) >> 1;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                l = mid + 1;
            } else {
                h = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    public int removeElement(int[] nums, int val) {
        int maxIndex = nums.length - 1;
        for (int i = 0; i < maxIndex + 1; ) {
            if (nums[i] == val) {
                int temp = nums[maxIndex];
                nums[maxIndex] = nums[i];
                nums[i] = temp;
                maxIndex--;
            } else {
                i++;
            }
        }
        return maxIndex + 1;
    }

    //删除有序数组中的重复项
    public int removeDuplicates(int[] nums) {
        int p = 0, q = 1;
        int count = 0;
        while (q < nums.length) {
            if (nums[p] == nums[q]) {
                count++;
                q++;
            } else {
                if (q - p > 1) {
                    nums[p + 1] = nums[q];

                }
                p++;
                q++;
            }
        }
        p++;
        while (p < nums.length) {
            nums[p++] = 10001;
        }
        return count;
    }

    //括号生成
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        dfs("", n, n, result);
        return result;
    }

    private void dfs(String s, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(s + "(", left - 1, right, result);
        }
        if (right > 0) {
            dfs(s + ")", left, right - 1, result);
        }
    }


    //四数之和
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                // 简单过滤
                int l = j + 1, h = nums.length - 1;
                while (l < h) {
                    int total = nums[i] + nums[j] + nums[l] + nums[h];
                    if (total == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[h]));
                        l++;
                        while (l < h && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        h--;
                        while (l < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                    } else if (total < target) {
                        l++;
                    } else {
                        h--;
                    }
                }
            }
        }
        return result;
    }

    //电话号码的字母组合
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        // 当前节点的解答
        List<String> cur = letterCombination(phoneMap.get(digits.charAt(0)));
        for (int i = 1; i < digits.length(); i++) {
            List<String> next = letterCombination(phoneMap.get(digits.charAt(i)));
            cur = combine(cur, next);
        }
        return cur;
    }

    public ArrayList<String> letterCombination(String s) {
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            temp.add(s.charAt(i) + "");
        }
        return temp;
    }

    public ArrayList<String> combine(List<String> s, List<String> e) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < e.size(); j++) {
                result.add(s.get(i) + e.get(j));
            }
        }
        return result;
    }

    // 指定瑕疵度最长字串长度
    public int longestKSub(String s, int k) {

        HashSet yuanyin = new HashSet(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        Queue<Integer> queue = new LinkedList();
        int count = 0;
        int max = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            if (!yuanyin.contains(s.charAt(right))) {
                // 记录位置
                queue.add(right);
                if (count == k) {
                    // 更新max
                    max = Math.max(max, right - left);
                    // 滑动左指针
                    left = queue.poll() + 1;
                    right++;
                } else {
                    right++;
                    count++;
                }
            } else {
                right++;
            }
        }
        if (count <= k) {
            max = Math.max(max, right - left);
        }
        return max;
    }

    //最接近的三数之和
    public int threeSumClosest(int[] nums, int target) {
        int min = 3000;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, h = nums.length - 1;
            while (l < h) {
                int total = nums[i] + nums[l] + nums[h];
                if (total == target) {
                    return target;
                }
                // 更新min
                if (Math.abs(total - target) < Math.abs(min - target)) {
                    min = total;
                }
                if (total < target) {
                    l++;
                } else {
                    h--;
                }
            }
        }
        return min;
    }

    //三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, h = nums.length - 1;
            while (l < h) {
                int total = nums[i] + nums[l] + nums[h];
                if (total == 0) {
                    result.add(List.of(nums[i], nums[l], nums[h]));
                    while (l < h && nums[h] != nums[h - 1]) {
                        h--;
                    }
                    while (l < h && nums[l] != nums[l - 1]) {
                        l++;
                    }
                    h--;
                    l++;
                } else if (total < 0) {
                    l++;
                } else {
                    h--;
                }

            }
        }
        return result;
    }

    //最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        int maxLength = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    return strs[0].substring(0, maxLength);
                }
                if (c != strs[j].charAt(i)) {
                    return strs[0].substring(0, maxLength);
                }
            }
            maxLength++;
        }
        return strs[0].substring(0, maxLength);

    }

    //整数转罗马数字
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        while (num != 0) {
            while (num >= numbers[index]) {
                num = num - numbers[index];
                sb.append(letters[index]);
            }
            index++;
        }
        return sb.toString();
    }

    //盛最多水的容器
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }


    //搜索旋转排序数组
    public int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[l] <= nums[mid]) {
                    if (target < nums[mid] && target >= nums[l]) {
                        h = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (target > nums[mid] && target <= nums[h]) {
                        l = mid + 1;
                    } else {
                        h = mid - 1;
                    }
                }
            }
        }
        return -1;

    }


    //最大数 字符串
    public String largestNumber(int[] nums) {
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ss[i] = "" + nums[i];
        }
        Arrays.sort(ss, (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : ss
        ) {
            System.out.println(s);
            sb.append(s);
        }

        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        return sb.substring(i);

    }

    // 供暖器
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int max = 0;
        for (int i = 0, j = 0; i < houses.length; ) {
            int housesP = houses[i];
            int preHeatersP = j == 0 ? heaters[0] : heaters[j - 1];
            int heatersP = heaters[j];
            if (heatersP >= housesP) {
                max = Math.max(Math.min(heatersP - housesP, Math.abs(housesP - preHeatersP)), max);
                i++;
            } else {
                if (j < heaters.length - 1) {
                    j = j + 1;
                } else {
                    max = Math.max(max, Math.abs(houses[houses.length - 1] - heatersP));
                    break;
                }
            }
        }
        return max;
    }

    public List<List<Integer>> permute2(int[] nums) {
        return new LinkedList<>(permute(nums));
    }

    //全排列
    public List<LinkedList<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            List<LinkedList<Integer>> result = new LinkedList<>();
            LinkedList<Integer> inResult = new LinkedList<>();
            inResult.add(nums[0]);
            result.add(inResult);
            return result;
        }
        List<LinkedList<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            List<LinkedList<Integer>> subResult = permute(internalNums(nums, i));
            for (LinkedList<Integer> internal : subResult) {
                internal.addFirst(nums[i]);
            }
            result.addAll(subResult);
        }
        return result;
    }

    public int[] internalNums(int[] nums, int i) {
        int[] result = new int[nums.length - 1];
        for (int j = 0, k = 0; j < nums.length; j++) {
            if (j == i) {
                continue;
            }
            result[k] = nums[j];
            k++;
        }
        return result;
    }

    //整数回文
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return x == reverse(x);
    }

    //整数反转
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int temp = result * 10 + x % 10;
            if (temp / 10 != result) {
                return 0;
            }
            result = temp;
            x = x / 10;
        }
        return result;
    }

    //每日温度
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temp = new Stack<>();
        int length = temperatures.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
//           if (temp)
        }
        return result;
    }

    //森林兔子
    public int numRabbits(int[] answers) {
        int result = 0;
        int[] sameCount = new int[10000];

        for (int i = 0; i < answers.length; i++) {
            int count = answers[i];
            if (sameCount[count] == 0) {
                result += count + 1;
                sameCount[count] = count;
            } else {
                sameCount[count] = sameCount[count] - 1;
            }
        }
        return result;

//        HashMap<Integer, Integer> count = new HashMap<>();
//        for (int i = 0; i < answers.length; i++) {
//            if (count.containsKey(i)) {
//                count.put(i, count.get(i) + 1);
//            } else {
//                count.put(i, 1);
//            }
//        }
//        int result = 0;
//        for (Map.Entry<Integer, Integer> integerIntegerEntry : count.entrySet()) {
//            int x = integerIntegerEntry.getValue();
//            int y = integerIntegerEntry.getKey();
//            if( x%(y+1)==0 ){
//                result += x/(y+1) * (y+1);
//            }else{
//                result += ( x/(y+1) + 1 ) * (y + 1);
//            }
//        }
//        return result;
    }

    // 跳跃
    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;
            k = Math.max(k, nums[i] + i);
        }
        return true;
    }

    // 跳跃 最小步数
    public int jump2(int[] nums) {
        int step = 0;
        int nextMaxPosition = 0;
        int curMaxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextMaxPosition = Math.max(nextMaxPosition, nums[i] + i);
//            if( nextMaxPosition >= nums.length-1){
//                step++;
//                break;
//            }
            if (i == curMaxPosition) {
                curMaxPosition = nextMaxPosition;
                step++;
            }
        }
        return step;
    }

    public int jump(int[] nums) {
        int position = nums.length - 1;
        int count = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (nums[i] + i >= position) {
                    position = i;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    // 排序 再取偶数位数值求和
    public int arrayPairSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] += 10000;
        }

        int R = 20001;
        int[] count = new int[R + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] + 1]++;
        }
        for (int i = 0; i < R; i++) {
            count[i + 1] += count[i];
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count[nums[i]] % 2 == 1) {
                result += nums[i];
            }
            count[nums[i]]++;
        }
        return result - nums.length * 5000;
//        Arrays.sort(nums);
//        int result = 0;
//        for (int i = 0; i < nums.length; i += 2) {
//            result += nums[i];
//        }
//         return result;


    }

}
