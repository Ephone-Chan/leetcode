package lcof;

public class P11_xuan_zhuan_shu_zu_de_zui_xiao_shu_zi {

    public static int minArray(int[] numbers) {

        if (numbers == null || numbers.length == 0)
            return -1;

        int head = 0, tail = numbers.length - 1;

        // 当数组为有序数组时（即旋转了 0 个元素），返回首元素
        int mid = 0;

        while (numbers[head] >= numbers[tail]) {

            //首尾相差一位时, 尾指针为最小值
            if (head + 1 == tail)
                return numbers[tail];

            //计算中间位置
            mid = (head + tail) / 2;

            //中间与首尾一致时，无法区分前后段，采用顺序查找
            if ((numbers[mid] == numbers[head]) && (numbers[mid] == numbers[tail])) {
                int min = numbers[head];
                for (int i = head + 1; i <= tail; i++) {
                    if (numbers[i] < min)
                        min = numbers[i];
                }
                return min;
            }


            if (numbers[mid] >= numbers[head])
                head = mid;
            else
                tail = mid;

        }
        return numbers[mid];
    }

    public static void main(String[] args) {

        int[] arr = {3,1};

        System.out.println(minArray(arr));
    }


}
