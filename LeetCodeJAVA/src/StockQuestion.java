public class StockQuestion {
    /*
    https://leetcode-cn.com/circle/article/qiAgHn/
    i-第i天，k-最多进行k次交易，0-手中持有股票，1-手中没有，T-最大利润
    基准情况：
        T[-1][k][0] = 0, T[-1][k][1] = -Infinity
        T[i][0][0] = 0, T[i][0][1] = -Infinity
    状态转移方程：
        T[i][k][0] = max(T[i - 1][k][0], T[i - 1][k][1] + prices[i])
        T[i][k][1] = max(T[i - 1][k][1], T[i - 1][k - 1][0] - prices[i])
     */
    public int maxProfit1(int[] prices) {
        /*
        https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
        买卖一次，求最大利益
         */
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit0 = 0, profit1 = -prices[0];
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            profit0 = Math.max(profit0, profit1 + prices[i]);
            profit1 = Math.max(profit1, -prices[i]);
        }
        return profit0;
    }

    public int maxProfit2(int[] prices){
        /*
        https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
        不限次数，最大利益
         */
        if(prices == null ||prices.length==0){
            return 0;
        }
        int length = prices.length;
//        int[][] dp = new int[length][2];
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//        for (int i = 1; i < length; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
//        }
        int profit0 = 0;
        int profit1 = -prices[0];
        for(int i=1;i<length;i++){
            int newProfit0 = Math.max(profit1+prices[i],profit0);
            int newProfit1 = Math.max(profit0-prices[i],profit1);
            profit0 = newProfit0;
            profit1 = newProfit1;
        }
        return profit0;
    }
    public int maxProfit3(int[] prices){
        /*
        https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
        最多两笔,最大利润
         */
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
/*        int[][][] dp = new int[length][3][2];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
        }
        return dp[length - 1][2][0];
*/
        int sell1 = 0;
        int buy1 = -prices[0];
        int sell2 = 0;
        int buy2 = -prices[0];
        for (int i = 1; i < length; i++) {
            buy1 = Math.max(buy1,- prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
        }
    public int maxProfit4(int[] prices,int k){
        /*
        https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
        任意次数，最大利益
         */
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        if (k >= length / 2) {
            return maxProfit2(prices);
        }
        int[][] dp = new int[k + 1][2];
        for (int i = 1; i <= k; i++) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = k; j > 0; j--) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
            }
        }
        return dp[k][0];
    }
    public int maxProfit5(int[] prices){
        /*
        https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
        k无穷，冷冻期1天
         */
        if(prices ==null || prices.length==0){
            return 0;
        }
        int length = prices.length;
/*      int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=2;i<length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[1]);
            dp[i][1] = Math.max(dp[i-1][1],(i>=2?dp[i-2][0]:0)-prices[i]);
        }
        return dp[length-1][0];
 */
        int sell = 0;
        int prev = 0;
        int buy = -prices[0];
        for(int i=2;i<length;i++){
            int newSell = Math.max(sell,buy+prices[i]);
            int newBuy = Math.max(buy,prev-prices[i]);
            prev = sell;
            sell = newSell;
            buy = newBuy;
        }
        return sell;
    }
    public int maxProfit6(int[] prices,int fee){
        /*
        https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
        无限次交易，需要手续费
         */
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit0 = 0, profit1 = -prices[0];
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            int newProfit0 = Math.max(profit0, profit1 + prices[i] - fee);
            int newProfit1 = Math.max(profit1, profit0 - prices[i]);
            profit0 = newProfit0;
            profit1 = newProfit1;
        }
        return profit0;
    }

}
