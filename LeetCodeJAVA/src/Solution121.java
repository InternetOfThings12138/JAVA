public class Solution121 {
    /*
    url:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
    买卖股票的最佳时机：买卖一次，最大利润。
     */
    public int maxProfit(int[] prices){
        int max = 0;
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                int profit = prices[j]-prices[i];
                if(profit>max){
                    max = profit;
                }
            }
        }
        return max;
    }


    public int maxProfit1(int[] prices){
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i = 0;i < prices.length;i++){
            if(prices[i] < minprice){
                minprice = prices[i];
            }
            if((prices[i]-minprice)>maxprofit){
                maxprofit = prices[i]-minprice;
            }
        }
        return maxprofit;
    }
    public int maxProfit2(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] prices = {2, 5, 1, 3};
        Solution121 Solu = new Solution121();
        int res = Solu.maxProfit1(prices);
        System.out.println(res);
    }
}

