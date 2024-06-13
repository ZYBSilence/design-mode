package leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @description:
 * @author: zhangyabo
 * @date: 20/03/2024 1:53 pm
 */
public class Q0004 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
//        int k = removeDuplicates(nums);
        int k = removeDuplicates2(nums);
        System.out.println(JSON.toJSONString(nums));
        System.out.println(k);
    }

    // 80. 删除有序数组中的重复项 II https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
    public static int removeDuplicates(int[] nums) {
        // 基于计数实现方案
        int beginIndex = 1;
        int tempValue = nums[0];
        int showNum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == tempValue) {
                if (showNum < 2) {
                    nums[beginIndex] = nums[i];
                    beginIndex++;
                }
                showNum++;
            } else if (nums[i] > tempValue) {
                nums[beginIndex] = nums[i];
                tempValue = nums[i];
                beginIndex++;
                showNum = 1;
            }
        }
        return beginIndex;
    }

    public static int removeDuplicates2(int[] nums) {
        // 看完题解后基于双指针实现
        int length = nums.length;
        if (length <= 2) {
            return length;
        }
        int beginIndex = 2;
        for (int i = 2; i < length; i++) {
            if (nums[i] != nums[beginIndex - 2]) {
                nums[beginIndex] = nums[i];
                beginIndex++;
            }
        }
        return beginIndex;
    }
}
