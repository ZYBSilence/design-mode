package leetcode;

/**
 * @description:
 * @author: zhangyabo
 * @date: 22/04/2024 3:44 pm
 */
public class Q0008 {
    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {1, 2, 3, 4, 5};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    // 122. 买卖股票的最佳时机 II https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i <= prices.length - 1; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                maxProfit += profit;
            }
        }
        return maxProfit;
    }

}
