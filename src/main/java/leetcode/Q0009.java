package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: zhangyabo
 * @date: 22/04/2024 3:58 pm
 */
public class Q0009 {
    public static void main(String[] args) {
        int[] prices = {3, 2, 1, 0, 4};
//        int[] prices = {2,3,1,1,4};
        System.out.println(canJump(prices));
    }

    // 55. 跳跃游戏 https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
    public static boolean canJump(int[] nums) {
        if (nums.length == 1 && nums[0] == 1) {
            return true;
        }
        int beginIndex = 0;
        int lastIndex = nums.length - 1;
        Set<Integer> indexSet = new HashSet<>();
        while (!indexSet.contains(beginIndex) && (beginIndex + nums[beginIndex] < lastIndex)) {
            indexSet.add(beginIndex);
            beginIndex = nums[beginIndex];
        }
        return beginIndex + nums[beginIndex] >= lastIndex;
    }
}
