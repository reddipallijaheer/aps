class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice=Integer.MAX_VALUE;
        if(prices.length==1) return 0;
        int max=0;
        for(int i=0;i<prices.length;i++){
            if(buyPrice<prices[i]){
                max=Math.max(max,prices[i]-buyPrice);
            }
            else{
                buyPrice=prices[i];
            }
        }
        return max;
    }


}