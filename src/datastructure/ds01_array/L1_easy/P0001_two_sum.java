package datastructure.ds01_array.L1_easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P0001_two_sum {


    /*
    哈希表查找
     */
    public int[] twoSum_01(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
            map.put(nums[i],i);

        for(int i = 0; i < nums.length; i++){
            int search = target - nums[i];
            if(map.get(search) != null && map.get(search) != i)
                return new int[]{i , map.get(search)};

        }
        return null;
    }


    /*
    排序后的双指针扫描
     */
    public int[] twoSum02(int[] nums, int target) {

        Element[] elements = new Element[nums.length];

        for(int i = 0; i < nums.length; i++)
            elements[i] = new Element(nums[i],i);

        Arrays.sort(elements);

        int start = 0, end = nums.length-1;

        while(start < end){

            int sum = elements[start].data + elements[end].data;

            if(sum == target){
                if(elements[start].index < elements[end].index)
                    return new int[] {elements[start].index, elements[end].index};
                else
                    return new int[] {elements[end].index,elements[start].index};
            }
            else if(sum > target)
                end--;
            else
                start++;
        }
        return null;
    }

    private class Element implements Comparable{

        private Integer data;
        private Integer index;

        public Element(Integer data,Integer index){
            this.data = data;
            this.index = index;
        }

        @Override
        public int compareTo(Object o) {
            if(this.data > ((Element)o).data)
                return 1;
            else if(this.data < ((Element)o).data)
                return -1;
            return 0;
        }

        @Override
        public String toString() {
            return "{data:"+ data +",index:"+index+"}";
        }
    }
}
