package algorithm.alg01_dynamicprogramming.L2_middle;

import java.util.HashSet;
import java.util.Set;

public class P0983_minimum_cost_for_tickets {

    public static int mincostTickets(int[] days, int[] costs) {

        Set<Integer> set = new HashSet<>();

        for(int i : days)
            set.add(i);

        int lastDay = days[days.length-1];

        int[] memo = new int[lastDay + 1];

        memo[0] = 0;    //第 0 天，不会出门，肯定不会花钱

        for(int i = 1; i <= lastDay; i++){

            //今天不用出门，票价参考上一天
            if(!set.contains(i)){
                memo[i] = memo[i-1];
                continue;
            }

            int min_cost = memo[i-1] + costs[0];    //决策1：前一天基础上买一张票

            //决策2：回到 7 天前买一张票用到今天
            //具体分为当前天数是否大于 7 天，
            //  如果大于 7 天，则回到 7 天前，再买一张 7 天票
            //  否则从第 0 天开始买张 7 天票，一直用到今天
            if(i >= 7)
                min_cost = Math.min(min_cost, memo[i-7] + costs[1]);
            if(i < 7)
                min_cost = Math.min(min_cost, costs[1]);

            //决策3：回到 30 天前买一张票用到今天
            //具体分为当前天数是否大于 30 天，
            //  如果大于 30 天，则回到 30 天前，再买一张 30 天票
            //  否则从第 0 天开始买张 30 天票，一直用到今天
            if(i >= 30)
                min_cost = Math.min(min_cost, memo[i-30] + costs[2]);
            if(i < 30)
                min_cost = Math.min(min_cost, costs[2]);
        }
        return memo[lastDay];
    }

    public static void main(String[] args) {

        int[] days = {1, 4, 6, 7, 8, 20};

        int[] costs = {2, 7, 15};

        System.out.println(mincostTickets(days, costs));
    }


}
