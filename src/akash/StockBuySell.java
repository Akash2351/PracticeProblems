package akash;

/**
 * Created by akash on 16-10-2017.
 */
public class StockBuySell {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        if (prices == null || prices.length == 1 || prices.length == 0)
            return profit;

        int minStock = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minStock)
                minStock = prices[i];
            else {
                int tempP = prices[i] - minStock;
                profit = tempP > profit ? tempP : profit;
            }
        }
        return profit;
    }
}
