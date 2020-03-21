package hard;

public class WildcardMatch {


    /*
    遇到 * 号时，分别记录 主串s 的位置（i_star）和 模式串p 的位置（j_star），
    因为 * 可以匹配空串，所以 i 回到 i -1 位置，在下一轮循环中主串从 * 号位置与模式串在 * 的下一位开始对比
    如果遇到不相等的字符，则 i 回退至 i_star+1 重新与 j_star 开始匹配，将前面的字符作为与 * 进行了匹配，寄希望于在后续的位置中寻找与 * 之后相等的字符序列
    当模式串匹配到结尾时进行回退，让主串s继续向前推进，保持 * 号之后直至结束位置的字符序列相等
     */
    public boolean isMatch(String s, String p) {

        boolean star = false;

        int i = 0, j = 0, i_star = 0, j_star = 0;

        for (; i <= s.length() - 1; i++, j++) {

            //情况1:模式串的字符为?,任意单个字符匹配
            if (j <= p.length() - 1 && p.charAt(j) == '?')
                continue;

            //情况2:模式串的字符为*,记录当前主串和模式串的位置
            if (j <= p.length() - 1 && p.charAt(j) == '*') {
                star = true;
                i_star = i;
                j_star = j;
                while (j_star <= p.length() - 1 && p.charAt(j_star) == '*')    //多个连续的 * 与 一个 * 作用一样
                    j_star++;
                if (j_star == p.length())    //模式串最后一个字符为*
                    return true;
                i = i_star - 1; // * 可以代表空字符,故i回到i-1的位置,在一轮循环中于 i 位置与模式串*之后的字符作比较
                j = j_star - 1; // j 的位置为当前的*,在下一轮循环中会推进到*之后的位置
                continue;
            }

            //情况3:回退, 模式串推进到结束 或 主串与模式串的字符不匹配,且有*出现
            //回退逻辑:主串在 * 的位置上向前推进一位,忽略不匹配的字符,寄希望于跳过之后的字符序列中能有和模式串*之后的字符序列相匹配
            //举例说明:
            // S:abbccd  P:a*ccc
            // 1.b != c, 忽略当前的b,向前推进. j_star在第一个c保持不变
            // 2.b != c, 继续忽略向前推,i_star推进至第一个c, j_star仍旧不变
            // 3.c = c, i 和 j 同时向前推
            // 4.与3一致
            // 5.d != c, i_star推进到第2个c,i回退至i_star-1,j回退至j_star-1,回到 for 循环中,i和j会被向前推进
            // 寄希望于第2个c开始的字符串序列可以匹配模式串*之后的字符序列
            if ((j == p.length() || s.charAt(i) != p.charAt(j)) && star) {
                i_star++;
                i = i_star - 1;
                j = j_star - 1;
                continue;
            }

            //情况4:模式串已匹配完主串还有剩余字符 或 出现不匹配的字符,且没有*出现
            if (j == p.length() || s.charAt(i) != p.charAt(j))
                return false;

        }

        while (j <= p.length() - 1 && p.charAt(j) == '*')  //模式串的指针还没匹配完
            j++;

        return j == p.length(); //所有字符都匹配完毕,j为模式串p的长度

    }


    /*
    使用新增一个末位的特殊字符实现模式串p到了终点的回退
     */
    public boolean isMatch02(String s, String p) {

        char[] s_arr = new char[s.length() + 1];
        s_arr[s.length()] = '\0';
        for (int a = 0; a < s.length(); a++)
            s_arr[a] = s.charAt(a);

        char[] p_arr = new char[p.length() + 1];
        p_arr[p.length()] = '\0';
        for (int a = 0; a < p.length(); a++)
            p_arr[a] = p.charAt(a);

        int i = 0, j = 0, i_star = 0, j_star = 0;

        boolean star = false;

        for (; i < s_arr.length; i++, j++) {

            switch (p_arr[j]) {
                case '?':
                    break;
                case '*':
                    star = true;
                    i_star = i;
                    j_star = j;
                    while (j_star < p_arr.length && p_arr[j_star] == '*')
                        j_star++;
                    if (j_star == p_arr.length)
                        return true;
                    i = i_star - 1;
                    j = j_star - 1;
                    break;
                default:
                    if (s_arr[i] != p_arr[j]) {
                        if (!star)
                            return false;
                        i_star++;
                        i = i_star - 1;
                        j = j_star - 1;
                    }
            }
        }
        while (j < p.length() && p_arr[j] == '*')
            j++;
        return j == p_arr.length;
    }


    public static void main(String[] args) {

        WildcardMatch wildcardMatch = new WildcardMatch();

        System.out.println(wildcardMatch.isMatch("abceb", "*a*b"));

    }

}
