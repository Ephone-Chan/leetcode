package algorithm.alg09_binarysearch.L1_easy;

public class P0069_sqrtx {

    public static int mySqrt(int x) {
        if( x <= 1)
            return 1;

        double left = 0 , right = x, mid = x/2.0f;

        while (left < right){

            if(mid * mid - x  > 0 && mid * mid -x < 0.001)
                return (int)mid;

            if(mid * mid - x  < 0 && mid * mid -x > -0.001)
                return (int)mid;

            if(mid * mid > x)
                right = mid;
            else
                left = mid;

            mid = (left + right)/2.0f;
        }

        return -1;
    }

    public static void main(String[] args){


        System.out.println(mySqrt(2147395599));

//        System.out.println(Math.sqrt(2147395599));

    }
}
