package leetcode;

import com.alibaba.fastjson.JSON;


/**
 * @description:
 * @author: zhangyabo
 * @date: 20/03/2024 11:07 am
 */
public class Q0002 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int newArrayLength = removeElement(nums, 2);
        System.out.println(JSON.toJSONString(nums));
        System.out.println(newArrayLength);
    }

    // 27. 移除元素 https://leetcode.cn/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
    public static int removeElement(int[] nums, int val) {
        int beginIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[beginIndex] = nums[i];
                beginIndex++;
            }
        }
        return beginIndex;
    }
}
