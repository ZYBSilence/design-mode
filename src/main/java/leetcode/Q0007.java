package leetcode;

/**
 * @description:
 * @author: zhangyabo
 * @date: 21/03/2024 9:14 pm
 */
public class Q0007 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {7, 6, 4, 3, 1};
//        int maxProfit = maxProfit(prices);
        int maxProfit = maxProfit2(prices);
        System.out.println(maxProfit);
    }

    // 121. 买卖股票的最佳时机 https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
    public static int maxProfit(int[] prices) {
        int maxNum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int j = i + 1;
            while (j < prices.length) {
                int tempNum = prices[j] - prices[i];
                if (tempNum > maxNum) {
                    maxNum = tempNum;
                }
                j++;
            }
        }
        return maxNum;
    }

    public static int maxProfit2(int[] prices) {
        int minNum = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minNum) {
                minNum = price;
            } else if (price - minNum > maxProfit) {
                maxProfit = price - minNum;
            }
        }
        return maxProfit;
    }
}
