package leetcode;

import java.util.Arrays;

/**
 * @description:
 * @author: zhangyabo
 * @date: 20/03/2024 6:25 pm
 */
public class Q0005 {
    public static void main(String[] args) {

        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    // 169. 多数元素 https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
    public static int majorityElement(int[] nums) {
        int halfLength = nums.length / 2;
        Arrays.sort(nums);
        return nums[halfLength];
    }
}
