package lcof;

public class P05_ti_huan_kong_ge {

    public static String replaceSpace(String s) {

        int space_count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                space_count++;
        }

        //原字符串无空格
        if (space_count == 0)
            return s;

        char[] dest_str = new char[s.length() + 2 * space_count];

        int source_index = s.length() - 1, dest_index = dest_str.length - 1;


        while (source_index >= 0) {

            // 原串出现空格
            if (s.charAt(source_index) == ' ') {
                source_index--;

                dest_str[dest_index--] = '0';
                dest_str[dest_index--] = '2';
                dest_str[dest_index--] = '%';
            } else
                dest_str[dest_index--] = s.charAt(source_index--);
        }
        return new String(dest_str);
    }

    public static void main(String[] args) {


        System.out.println(replaceSpace("   123 222 333 444 23423     "));

    }
}
