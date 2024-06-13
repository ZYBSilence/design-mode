package leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @description:
 * @author: zhangyabo
 * @date: 20/03/2024 1:42 pm
 */
public class Q0003 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = removeDuplicates(nums);
        System.out.println(JSON.toJSONString(nums));
        System.out.println(k);
    }

    // 26. 删除有序数组中的重复项 https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
    public static int removeDuplicates(int[] nums) {
        int beginIndex = 1;
        int tempValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tempValue) {
                tempValue = nums[i];
                nums[beginIndex] = tempValue;
                beginIndex++;
            }
        }
        return beginIndex;
    }
}
