package datastructure.ds05_string.L2_middle;

public class P0151_reverse_words_in_a_string {
    public static String reverseWords(String s) {

        String[] list = s.trim().split("\\s\\s*");

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = list.length-1; i >=0; i--) {
            stringBuilder.append(list[i]);
            if(i > 0)
                stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }


    public static void main(String[] args){

        System.out.println(reverseWords("the sky is blue"));

    }
}
