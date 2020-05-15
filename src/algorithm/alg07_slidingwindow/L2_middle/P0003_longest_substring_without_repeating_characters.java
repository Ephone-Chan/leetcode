package algorithm.alg07_slidingwindow.L2_middle;

import java.util.HashSet;
import java.util.Set;

public class P0003_longest_substring_without_repeating_characters {


    /*
        最长无重复子串，滑动窗口
     */

    public static int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int res = 0;

        int flowPointer = -1;

        for(int i = 0; i < s.length(); i++){

            if(i > 0)
                set.remove(s.charAt(i-1));

            while(flowPointer + 1 < s.length() && ! set.contains(s.charAt(flowPointer+1))){

                set.add(s.charAt(flowPointer+1));

                flowPointer ++;
            }
            res = Math.max(res, set.size());
        }

        return res;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("pwwkewb"));
    }


}
