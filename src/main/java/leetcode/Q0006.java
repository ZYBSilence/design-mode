package leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @description:
 * @author: zhangyabo
 * @date: 20/03/2024 6:55 pm
 */
public class Q0006 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        rotate(nums, 3);
        rotate2(nums, 3);
        System.out.println(JSON.toJSONString(nums));
    }

    // 189. 轮转数组 https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int moveNum = k % length;
        while (moveNum > 0) {
            int tempNum = nums[length - 1];
            int readNum = length - 1;
            while (readNum > 0) {
                nums[readNum] = nums[--readNum];
            }
            nums[0] = tempNum;
            moveNum--;
        }
    }

    public static void rotate2(int[] nums, int k) {
        int length = nums.length;
        int moveNum = k % length;
        int[] nums2 = new int[length];
        for (int i = 0; i < length; i++) {
            if (i + moveNum >= length) {
                nums2[i + moveNum - length] = nums[i];
            } else {
                nums2[i + moveNum] = nums[i];
            }
        }
        System.arraycopy(nums2, 0, nums, 0, length);
//        while (length > 0) {
//            nums[length - 1] = nums2[length - 1] ;
//            length--;
//        }
    }
}
