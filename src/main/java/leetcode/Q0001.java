package leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @description:
 * @author: zhangyabo
 * @date: 19/03/2024 5:16 pm
 */
public class Q0001 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
//        mergeTwoArray(nums1, nums2, 3, 3);
        mergeTwoArray2(nums1, nums2, 3, 3);

//        int[] nums1 = {1};
//        int[] nums2 = {};
//        mergeTwoArray(nums1, nums2, 1, 0);

//        int[] nums1 = {0};
//        int[] nums2 = {1};
//        mergeTwoArray(nums1, nums2, 0, 1);

//        int[] nums1 = {2, 0};
//        int[] nums2 = {1};
//        mergeTwoArray(nums1, nums2, 1, 1);
//        mergeTwoArray2(nums1, nums2, 1, 1);
        System.out.println(JSON.toJSONString(nums1));
    }

    // 88. 合并两个有序数组 https://leetcode.cn/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
    private static void mergeTwoArray(int[] nums1, int[] nums2, int m, int n) {
        if (m == 0) {
            while (n > 0) {
                nums1[n - 1] = nums2[n - 1];
                n--;
            }
        }
        int lastIndex = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] <= nums2[n - 1]) {
                nums1[lastIndex] = nums2[n - 1];
                n--;
            } else {
                nums1[lastIndex] = nums1[m - 1];
                m--;
            }
            lastIndex--;
        }
        while (lastIndex >= 0 && n > 0) {
            nums1[lastIndex] = nums2[n - 1];
            lastIndex--;
            n--;
        }
    }

    private static void mergeTwoArray2(int[] nums1, int[] nums2, int m, int n) {
        int lastIndex = m + n - 1;
        m--;
        n--;

        while (m >= 0 && n >= 0) {
            // 两数组都有值的情况
            if (nums1[m] > nums2[n]) {
                nums1[lastIndex] = nums1[m];
                m--;
            } else {
                nums1[lastIndex] = nums2[n];
                n--;
            }
            lastIndex--;
        }

        while (n >= 0) {
            // 处理nums2数组还有数据未全部插入的情况
            nums1[lastIndex] = nums2[n];
            lastIndex--;
            n--;
        }
    }

}

