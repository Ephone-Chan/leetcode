package algorithm.alg04_backtrack.L3_hard;

public class P0010_zheng_ze_biao_da_shi_pi_pei {


    //01.回溯法
    //模式串出现 * 时，考虑两种情形
    //情形一：模式串跳过带 * 字符及 *，表示主串中没出现带 * 字符，若后续的位置都相等，则两个串匹配
    //情形二：主串中第一个字符与带 * 字符相等，主串向前推进，表示主串中出现连续多次出现带 * 字符，若后续的位置都相等，则两个串匹配
    //满足任意一种，都可说明两个字符串相匹配
    //第一种不满足会回溯到另一种继续向前推进
    public boolean isMatch(String s, String p) {

        //模式串结束，主串是否结束，同时结束，则匹配
        if (p.isEmpty())
            return s.isEmpty();

        //主串未结束，获取首位的对比状况
        boolean header = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        //模式串第二位为 *
        if(p.length() >= 2 && p.charAt(1) == '*')
            //任意一种情形下，两者后续全匹配，则两个字符串匹配
            return isMatch(s , p.substring(2)) || (header && isMatch(s.substring(1),p));
        else
            return header && isMatch(s.substring(1),p.substring(1));
    }

    public static void main(String[] args){


        P0010_zheng_ze_biao_da_shi_pi_pei regular_expression_matching = new P0010_zheng_ze_biao_da_shi_pi_pei();


        regular_expression_matching.isMatch("ab",".*c");

    }

}
